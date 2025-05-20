package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.widget.TextView
import com.example.kindergardenmanager.R

/**
 * Dashboard for Kitchen Staff users
 */
class KitchenStaffDashboardActivity : BaseDashboardActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitchen_staff_dashboard)
        
        // Set title
        title = getString(R.string.kitchen_dashboard)
        
        // Get user details
        val userDetails = sessionManager.getUserDetails()
        val firstName = userDetails[SessionManager.KEY_FIRST_NAME] ?: ""
        val lastName = userDetails[SessionManager.KEY_LAST_NAME] ?: ""
        
        // Display welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "${getString(R.string.welcome)}, $firstName $lastName!"
        
        // Initialize UI components and functionality specific to Kitchen Staff role
        setupKitchenStaffFunctionality()
    }
    
    private fun setupKitchenStaffFunctionality() {
        // TODO: Implement Kitchen Staff-specific functionality
        // - Manage meal plans and menus
        // - Track dietary restrictions
        // - Inventory management
        // - Food ordering system
    }
}