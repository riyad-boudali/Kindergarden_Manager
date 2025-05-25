package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Message
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.MessageRepository
import com.example.kindergardenmanager.ui.adapter.MessageAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewMessagesActivity : AppCompatActivity() {
    private lateinit var messageRepository: MessageRepository
    private lateinit var progressBar: ProgressBar
    private lateinit var tvNoMessages: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageAdapter

    private val userMap = mutableMapOf<Long, User>()
    private var userId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_messages)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Messages"

        // Get current user ID from session
        val sessionManager = (application as KindergardenApplication).sessionManager
        userId = sessionManager.getUserId()
        
        if (userId <= 0) {
            // Log for debugging
            android.util.Log.e("ViewMessagesActivity", "Invalid user ID: $userId")
            Toast.makeText(this, "Error retrieving user information", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        if (userId == 0L) {
            finish()
            return
        }

        // Initialize views
        progressBar = findViewById(R.id.progressBar)
        tvNoMessages = findViewById(R.id.tvNoMessages)
        recyclerView = findViewById(R.id.recyclerViewMessages)

        // Initialize repositories
        messageRepository = (application as KindergardenApplication).messageRepository

        // Set up adapter
        adapter = MessageAdapter(
            context = this,
            messages = emptyList(),
            senderMap = userMap,
            onMessageClick = { message -> onMessageClick(message) }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load teachers for sender info
        loadTeachers()

        // Load messages
        loadMessages()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadTeachers() {
        // Load teacher data to display sender information
        (application as KindergardenApplication).userRepository
            .getUsersByRole(UserRole.TEACHER)
            .observe(this, Observer { teachers ->
                if (teachers != null) {
                    teachers.forEach { teacher ->
                        userMap[teacher.userId] = teacher
                    }
                    adapter.notifyDataSetChanged()
                }
            })
    }

    private fun loadMessages() {
        showLoading(true)
        messageRepository.getMessagesForUser(userId).observe(this, Observer { messages ->
            showLoading(false)
            if (messages != null && messages.isNotEmpty()) {
                adapter.updateMessages(messages)
                tvNoMessages.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            } else {
                tvNoMessages.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        })
    }

    private fun onMessageClick(message: Message) {
        if (!message.isRead) {
            CoroutineScope(Dispatchers.IO).launch {
                messageRepository.markMessageAsRead(message.messageId)
            }
        }
        // You could start a new activity to show the full message here
        // For now, we'll just mark it as read
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
