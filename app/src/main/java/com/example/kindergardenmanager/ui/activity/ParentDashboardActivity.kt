package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.util.SessionManager

/**
 * Dashboard for Parent users
 */
class ParentDashboardActivity : BaseDashboardActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_dashboard)
        
        // Set up toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setupToolbar(toolbar, getString(R.string.parent_dashboard))
        
        // Get user details
        val userDetails = sessionManager.getUserDetails()
        val firstName = userDetails[SessionManager.KEY_FIRST_NAME] ?: ""
        val lastName = userDetails[SessionManager.KEY_LAST_NAME] ?: ""
        
        // Display welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "${getString(R.string.welcome)}, $firstName $lastName!"
        
        // Initialize UI components and functionality specific to Parent role
        setupParentFunctionality()

        // Set up 'Sign Out' button
        val btnSignOut = findViewById<Button>(R.id.btnSignOut)
        setupSignOutButton(btnSignOut)
    }
    
    private fun setupParentFunctionality() {
        val btnViewChildren = findViewById<Button>(R.id.btnViewChildren)
        val btnAttendance = findViewById<Button>(R.id.btnAttendance)
        val btnMessages = findViewById<Button>(R.id.btnMessages)

        btnViewChildren.setOnClickListener {
            Toast.makeText(this, "Viewing children is not implemented yet.", Toast.LENGTH_SHORT).show()
        }

        btnAttendance.setOnClickListener {
            Toast.makeText(this, "Viewing attendance records is not implemented yet.", Toast.LENGTH_SHORT).show()
        }

        btnMessages.setOnClickListener {
            val intent = Intent(this, ViewMessagesActivity::class.java)
            startActivity(intent)
        }
    }
}