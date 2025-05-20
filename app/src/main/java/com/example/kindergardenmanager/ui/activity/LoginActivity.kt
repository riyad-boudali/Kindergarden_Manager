package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.ui.viewmodel.AuthResult
import com.example.kindergardenmanager.ui.viewmodel.AuthViewModel
import com.example.kindergardenmanager.ui.viewmodel.AuthViewModelFactory
import com.example.kindergardenmanager.util.SessionManager
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var sessionManager: SessionManager
    
    // UI components
    private lateinit var etEmailUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var progressBar: View
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        // Initialize session manager
        sessionManager = SessionManager(this)
        
        // Check if user is already logged in
        if (sessionManager.isLoggedIn()) {
            navigateToDashboard()
            return
        }
        
        // Initialize ViewModel
        val kindergardenApp = application as KindergardenApplication
        val repository = kindergardenApp.userRepository
        val viewModelFactory = AuthViewModelFactory(repository)
        authViewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
        
        // Initialize UI components
        etEmailUsername = findViewById(R.id.etEmailUsername)
        etPassword = findViewById(R.id.etPassword)
        progressBar = findViewById(R.id.progressBar)
        
        // Set click listener for login button
        findViewById<View>(R.id.btnLogin).setOnClickListener {
            performLogin()
        }
        
        // Set click listener for register prompt
        findViewById<View>(R.id.tvRegisterPrompt).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
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
    
    private fun performLogin() {
        val emailOrUsername = etEmailUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        
        authViewModel.login(emailOrUsername, password)
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
    
    private fun navigateToDashboard() {
        val userRole = sessionManager.getUserRole()
        val intent = when (userRole) {
            com.example.kindergardenmanager.data.model.UserRole.ADMIN -> 
                Intent(this, AdminDashboardActivity::class.java)
            com.example.kindergardenmanager.data.model.UserRole.TEACHER -> 
                Intent(this, TeacherDashboardActivity::class.java)
            com.example.kindergardenmanager.data.model.UserRole.PARENT -> 
                Intent(this, ParentDashboardActivity::class.java)
            com.example.kindergardenmanager.data.model.UserRole.KITCHEN_STAFF -> 
                Intent(this, KitchenStaffDashboardActivity::class.java)
            else -> 
                Intent(this, LoginActivity::class.java)
        }
        
        startActivity(intent)
        finish()
    }
}
