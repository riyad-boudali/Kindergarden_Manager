package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.UserRepository
import com.example.kindergardenmanager.ui.adapter.UserActionListener
import com.example.kindergardenmanager.ui.adapter.UserListAdapter
import kotlinx.coroutines.runBlocking

class ViewUsersActivity : AppCompatActivity(), UserActionListener {

    private lateinit var userRepository: UserRepository
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvNoUsers: TextView
    private lateinit var adapter: UserListAdapter
    private var userList: List<User> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_users)

        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "All Users"

        // Initialize repository
        userRepository = (application as com.example.kindergardenmanager.KindergardenApplication).userRepository

        // Initialize views
        listView = findViewById(R.id.listViewUsers)
        progressBar = findViewById(R.id.progressBar)
        tvNoUsers = findViewById(R.id.tvNoUsers)
        
        // Show loading
        showLoading(true)
        
        // Add sample users if this is the first run (for testing purposes)
        addSampleUsersIfEmpty()

        // Observe users LiveData
        userRepository.getAllUsers().observe(this, Observer { users ->
            showLoading(false)
            if (users != null && users.isNotEmpty()) {
                // Update local user list
                userList = users
                
                // Update adapter with new data
                adapter = UserListAdapter(this, users, userRepository, this)
                listView.adapter = adapter
                tvNoUsers.visibility = View.GONE
            } else {
                tvNoUsers.visibility = View.VISIBLE
            }
        })
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    
    override fun onUserDeleted(user: User) {
        // The adapter already handles the deletion from the database
        // This is called after deletion is successful
        Toast.makeText(this, "User deleted: ${user.firstName} ${user.lastName}", Toast.LENGTH_SHORT).show()
    }
    
    override fun onUserEdit(user: User) {
        // Navigate to edit user activity
        val intent = Intent(this, EditUserActivity::class.java)
        intent.putExtra("USER_ID", user.userId)
        startActivity(intent)
    }
    
    override fun onResume() {
        super.onResume()
        // Refresh data when returning from edit activity
        userRepository.getAllUsers().observe(this, Observer { users ->
            if (users != null && users.isNotEmpty()) {
                userList = users
                adapter = UserListAdapter(this, users, userRepository, this)
                listView.adapter = adapter
            }
        })
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
    
    private fun addSampleUsersIfEmpty() {
        // This is just for testing - add some sample users if the database is empty
        userRepository.getAllUsers().observe(this, Observer { users ->
            if (users.isNullOrEmpty()) {
                // Add sample users in a background thread
                Thread {
                    val sampleUsers = listOf(
                        User(
                            username = "teacher1",
                            firstName = "John",
                            lastName = "Smith",
                            email = "john@school.com",
                            password = "password123",
                            role = UserRole.TEACHER,
                            phoneNumber = "555-1234"
                        ),
                        User(
                            username = "parent1",
                            firstName = "Jane",
                            lastName = "Doe",
                            email = "jane@email.com",
                            password = "password123",
                            role = UserRole.PARENT,
                            phoneNumber = "555-5678"
                        ),
                        User(
                            username = "kitchen1",
                            firstName = "Mary",
                            lastName = "Johnson",
                            email = "mary@school.com",
                            password = "password123",
                            role = UserRole.KITCHEN_STAFF,
                            phoneNumber = "555-9012"
                        )
                    )
                    
                    runOnUiThread {
                        Toast.makeText(this@ViewUsersActivity, "Adding sample users...", Toast.LENGTH_SHORT).show()
                    }
                    
                    sampleUsers.forEach {
                        try {
                            // Use runBlocking to call suspend functions from a non-coroutine context
                            runBlocking {
                                userRepository.registerUser(it)
                            }
                        } catch (e: Exception) {
                            // Ignore errors for sample data
                            e.printStackTrace()
                        }
                    }
                }.start()
            }
        })
    }
}
