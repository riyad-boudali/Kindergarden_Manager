package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.widget.TextView
import com.example.kindergardenmanager.R

/**
 * Dashboard for Admin users
 */
class AdminDashboardActivity : BaseDashboardActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)
        
        // Set title
        title = getString(R.string.admin_dashboard)
        
        // Get user details
        val userDetails = sessionManager.getUserDetails()
        val firstName = userDetails[SessionManager.KEY_FIRST_NAME] ?: ""
        val lastName = userDetails[SessionManager.KEY_LAST_NAME] ?: ""
        
        // Display welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "${getString(R.string.welcome)}, $firstName $lastName!"
        
        // Initialize UI components and functionality specific to Admin role
        setupAdminFunctionality()
    }
    
    private fun setupAdminFunctionality() {
        // TODO: Implement Admin-specific functionality
        // - User management (add/edit/delete users)
        // - View all teachers, parents, and kitchen staff
        // - System configuration
    }
}