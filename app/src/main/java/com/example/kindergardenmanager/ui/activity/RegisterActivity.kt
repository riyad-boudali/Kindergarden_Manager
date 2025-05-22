package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.ui.viewmodel.AuthResult
import com.example.kindergardenmanager.ui.viewmodel.AuthViewModel
import com.example.kindergardenmanager.ui.viewmodel.AuthViewModelFactory
import com.example.kindergardenmanager.util.SessionManager
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var authViewModel: AuthViewModel
    private lateinit var sessionManager: SessionManager
    
    // UI components
    private lateinit var etFirstName: TextInputEditText
    private lateinit var etLastName: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var rgUserRole: RadioGroup
    private lateinit var progressBar: View
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        
        // Initialize session manager
        sessionManager = SessionManager(this)
        
        // Set up toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        
        // Set up back button navigation
        toolbar.setNavigationOnClickListener {
            // Using the onBackPressedDispatcher instead of deprecated onBackPressed
            onBackPressedDispatcher.onBackPressed()
        }
        
        // Initialize ViewModel
        val kindergardenApp = application as KindergardenApplication
        val repository = kindergardenApp.userRepository
        val viewModelFactory = AuthViewModelFactory(repository)
        authViewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
        
        // Initialize UI components
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        rgUserRole = findViewById(R.id.rgUserRole)
        progressBar = findViewById(R.id.progressBar)
        
        // Set click listener for register button
        findViewById<View>(R.id.btnRegister).setOnClickListener {
            registerUser()
        }
        
        // Set click listener for login prompt
        findViewById<View>(R.id.tvLoginPrompt).setOnClickListener {
            finish() // Go back to login activity
        }
        
        // Observe auth result
        authViewModel.authResult.observe(this) { result ->
            when (result) {
                is AuthResult.Loading -> {
                    showLoading(true)
                }
                is AuthResult.Success -> {
                    showLoading(false)
                    sessionManager.createLoginSession(result.user)
                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                    navigateToDashboard()
                }
                is AuthResult.Error -> {
                    showLoading(false)
                    Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                }
                else -> {
                    // Do nothing
                }
            }
        }
    }
    
    private fun registerUser() {
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val username = etUsername.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()
        val userRole = getUserRoleFromRadioGroup()
        
        // Validate inputs
        if (firstName.isBlank() || lastName.isBlank() || username.isBlank() || 
            email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_LONG).show()
            return
        }
        
        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
            return
        }
        
        if (userRole == null) {
            Toast.makeText(this, "Please select a role", Toast.LENGTH_LONG).show()
            return
        }
        
        // Register user
        authViewModel.register(
            username = username,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            role = userRole,
            firstName = firstName,
            lastName = lastName,
            phoneNumber = if (phone.isBlank()) null else phone
        )
    }
    
    private fun getUserRoleFromRadioGroup(): UserRole? {
        val selectedRadioButtonId = rgUserRole.checkedRadioButtonId
        if (selectedRadioButtonId == -1) {
            return null
        }
        
        return when (selectedRadioButtonId) {
            R.id.rbTeacher -> UserRole.TEACHER
            R.id.rbParent -> UserRole.PARENT
            R.id.rbKitchenStaff -> UserRole.KITCHEN_STAFF
            else -> null
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
    
    private fun navigateToDashboard() {
        val userRole = sessionManager.getUserRole()
        val intent = when (userRole) {
            UserRole.ADMIN -> Intent(this, AdminDashboardActivity::class.java)
            UserRole.TEACHER -> Intent(this, TeacherDashboardActivity::class.java)
            UserRole.PARENT -> Intent(this, ParentDashboardActivity::class.java)
            UserRole.KITCHEN_STAFF -> Intent(this, KitchenStaffDashboardActivity::class.java)
            else -> Intent(this, LoginActivity::class.java)
        }
        
        startActivity(intent)
        finish()
    }
}
