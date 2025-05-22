package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class AddUserActivity : AppCompatActivity() {

    private lateinit var userRepository: UserRepository
    
    // UI components
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etFirstName: TextInputEditText
    private lateinit var etLastName: TextInputEditText
    private lateinit var etPhoneNumber: TextInputEditText
    private lateinit var rgUserRole: RadioGroup
    private lateinit var btnAddUser: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        
        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add New User"
        
        // Initialize repository
        userRepository = (application as KindergardenApplication).userRepository
        
        // Initialize UI components
        initializeViews()
        
        // Set up Add User button click listener
        btnAddUser.setOnClickListener {
            validateAndAddUser()
        }
    }
    
    private fun initializeViews() {
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etEmail = findViewById(R.id.etEmail)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        rgUserRole = findViewById(R.id.rgUserRole)
        btnAddUser = findViewById(R.id.btnAddUser)
        progressBar = findViewById(R.id.progressBar)
    }
    
    private fun validateAndAddUser() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val phoneNumber = etPhoneNumber.text.toString().trim()
        
        // Validate inputs
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || 
            firstName.isEmpty() || lastName.isEmpty()) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            return
        }
        
        // Get selected role
        val selectedRoleId = rgUserRole.checkedRadioButtonId
        if (selectedRoleId == -1) {
            Toast.makeText(this, "Please select a user role", Toast.LENGTH_SHORT).show()
            return
        }
        
        val userRole = when (selectedRoleId) {
            R.id.rbTeacher -> UserRole.TEACHER
            R.id.rbParent -> UserRole.PARENT
            R.id.rbKitchenStaff -> UserRole.KITCHEN_STAFF
            else -> UserRole.TEACHER // Default to teacher
        }
        
        // Create user object
        val newUser = User(
            username = username,
            password = password,
            email = email,
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber,
            role = userRole
        )
        
        // Add user to database
        addUser(newUser)
    }
    
    private fun addUser(user: User) {
        showLoading(true)
        
        lifecycleScope.launch {
            try {
                // Check if username or email already exists
                val existingUserByUsername = userRepository.getUserByUsername(user.username)
                val existingUserByEmail = userRepository.getUserByEmail(user.email)
                
                if (existingUserByUsername != null) {
                    showLoading(false)
                    Toast.makeText(
                        this@AddUserActivity, 
                        "Username already exists", 
                        Toast.LENGTH_SHORT
                    ).show()
                    return@launch
                }
                
                if (existingUserByEmail != null) {
                    showLoading(false)
                    Toast.makeText(
                        this@AddUserActivity, 
                        "Email already exists", 
                        Toast.LENGTH_SHORT
                    ).show()
                    return@launch
                }
                
                // Add user to database
                val userId = userRepository.registerUser(user)
                
                // Show success message and finish activity
                showLoading(false)
                Toast.makeText(
                    this@AddUserActivity, 
                    "User added successfully", 
                    Toast.LENGTH_SHORT
                ).show()
                finish()
                
            } catch (e: Exception) {
                showLoading(false)
                Toast.makeText(
                    this@AddUserActivity, 
                    "Error adding user: ${e.message}", 
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        btnAddUser.isEnabled = !isLoading
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
