package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditUserActivity : AppCompatActivity() {

    private lateinit var userRepository: UserRepository
    private lateinit var progressBar: ProgressBar
    
    // UI Elements
    private lateinit var etFirstName: TextInputEditText
    private lateinit var etLastName: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPhoneNumber: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var rgRole: RadioGroup
    private lateinit var rbTeacher: RadioButton
    private lateinit var rbParent: RadioButton
    private lateinit var rbKitchenStaff: RadioButton
    private lateinit var btnSaveUser: Button
    
    private var userId: Long = 0
    private lateinit var currentUser: User
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)
        
        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit User"
        
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        
        // Initialize repository
        userRepository = (application as com.example.kindergardenmanager.KindergardenApplication).userRepository
        
        // Initialize views
        initializeViews()
        
        // Get user ID from intent
        userId = intent.getLongExtra("USER_ID", 0)
        if (userId == 0L) {
            Toast.makeText(this, "Invalid user ID", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        
        // Load user data
        loadUserData()
        
        // Set up save button
        btnSaveUser.setOnClickListener {
            saveUserChanges()
        }
    }
    
    private fun initializeViews() {
        progressBar = findViewById(R.id.progressBar)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        rgRole = findViewById(R.id.rgRole)
        rbTeacher = findViewById(R.id.rbTeacher)
        rbParent = findViewById(R.id.rbParent)
        rbKitchenStaff = findViewById(R.id.rbKitchenStaff)
        btnSaveUser = findViewById(R.id.btnSaveUser)
    }
    
    private fun loadUserData() {
        showLoading(true)
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val user = userRepository.getUserById(userId)
                
                if (user != null) {
                    currentUser = user
                    
                    withContext(Dispatchers.Main) {
                        // Populate form with user data
                        etFirstName.setText(user.firstName)
                        etLastName.setText(user.lastName)
                        etUsername.setText(user.username)
                        etEmail.setText(user.email)
                        etPhoneNumber.setText(user.phoneNumber ?: "")
                        
                        // Set radio button based on role
                        when (user.role) {
                            UserRole.TEACHER -> rbTeacher.isChecked = true
                            UserRole.PARENT -> rbParent.isChecked = true
                            UserRole.KITCHEN_STAFF -> rbKitchenStaff.isChecked = true
                            else -> {
                                // Admin role - should not happen as we don't allow editing admins
                                Toast.makeText(this@EditUserActivity, "Cannot edit admin users", Toast.LENGTH_SHORT).show()
                                finish()
                            }
                        }
                        
                        showLoading(false)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@EditUserActivity, "User not found", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@EditUserActivity, "Error loading user: ${e.message}", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
    
    private fun saveUserChanges() {
        // Validate inputs
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val username = etUsername.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phoneNumber = etPhoneNumber.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()
        
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            return
        }
        
        // Check if password fields match
        if (password.isNotEmpty() && password != confirmPassword) {
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            return
        }
        
        // Determine selected role
        val role = when (rgRole.checkedRadioButtonId) {
            R.id.rbTeacher -> UserRole.TEACHER
            R.id.rbParent -> UserRole.PARENT
            R.id.rbKitchenStaff -> UserRole.KITCHEN_STAFF
            else -> {
                Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show()
                return
            }
        }
        
        // Show loading
        showLoading(true)
        
        // Create updated user object
        val updatedUser = User(
            userId = currentUser.userId,
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
            // Use existing password if new one is not provided
            password = if (password.isEmpty()) currentUser.password else password,
            role = role,
            phoneNumber = phoneNumber.ifEmpty { null },
            isActive = currentUser.isActive
        )
        
        // Save changes in background
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Check if username or email already exists (and belongs to a different user)
                val existingUserByUsername = userRepository.getUserByUsername(username)
                if (existingUserByUsername != null && existingUserByUsername.userId != userId) {
                    withContext(Dispatchers.Main) {
                        showLoading(false)
                        Toast.makeText(this@EditUserActivity, "Username already exists", Toast.LENGTH_SHORT).show()
                    }
                    return@launch
                }
                
                val existingUserByEmail = userRepository.getUserByEmail(email)
                if (existingUserByEmail != null && existingUserByEmail.userId != userId) {
                    withContext(Dispatchers.Main) {
                        showLoading(false)
                        Toast.makeText(this@EditUserActivity, "Email already exists", Toast.LENGTH_SHORT).show()
                    }
                    return@launch
                }
                
                // Update user in database
                userRepository.updateUser(updatedUser)
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(this@EditUserActivity, "User updated successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(this@EditUserActivity, "Error updating user: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        btnSaveUser.isEnabled = !isLoading
    }
}
