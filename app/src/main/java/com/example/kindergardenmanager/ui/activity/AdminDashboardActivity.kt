package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.util.SessionManager
import com.example.kindergardenmanager.data.model.UserRole

/**
 * Dashboard for Admin users
 */
class AdminDashboardActivity : BaseDashboardActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)
        
        // Set up toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setupToolbar(toolbar, getString(R.string.admin_dashboard))
        
        // Get user details
        val userDetails = sessionManager.getUserDetails()
        val firstName = userDetails[SessionManager.KEY_FIRST_NAME] ?: ""
        val lastName = userDetails[SessionManager.KEY_LAST_NAME] ?: ""
        
        // Display welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "${getString(R.string.welcome)}, $firstName $lastName!"
        
        // Ensure only admin can access this functionality
        if (sessionManager.getUserRole() != UserRole.ADMIN) {
            Toast.makeText(this, "Unauthorized access", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        
        // Initialize UI components and functionality specific to Admin role
        setupAdminFunctionality()
        
        // Set up 'Sign Out' button
        val btnSignOut = findViewById<Button>(R.id.btnSignOut)
        setupSignOutButton(btnSignOut)

        // Set up 'View All Users' button
        val btnViewUsers = findViewById<Button>(R.id.btnViewUsers)
        btnViewUsers.setOnClickListener {
            // Navigate to a new activity to display all users
            val intent = Intent(this, ViewUsersActivity::class.java)
            startActivity(intent)
        }

        // Set up 'Add User' button
        val btnAddUser = findViewById<Button>(R.id.btnAddUser)
        btnAddUser.setOnClickListener {
            // Navigate to Add User activity
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }

        // Set up 'Application Settings' button
        val btnAppSettings = findViewById<Button>(R.id.btnAppSettings)
        btnAppSettings.setOnClickListener {
            // Navigate to Application Settings activity
            val intent = Intent(this, AppSettingsActivity::class.java)
            startActivity(intent)
        }
        
        // Set up 'Manage Classes' button
        val btnManageClasses = findViewById<Button>(R.id.btnManageClasses)
        btnManageClasses.setOnClickListener {
            // Navigate to Manage Classes activity
            val intent = Intent(this, ManageClassesActivity::class.java)
            startActivity(intent)
        }
        
        // Set up 'Manage Student Enrollments' button
        val btnManageEnrollments = findViewById<Button>(R.id.btnManageEnrollments)
        btnManageEnrollments.setOnClickListener {
            // Navigate to Manage Enrollments activity
            val intent = Intent(this, ManageEnrollmentsActivity::class.java)
            startActivity(intent)
        }
    }
    
    private fun setupAdminFunctionality() {
        // TODO: Implement Admin-specific functionality
        // - User management (add/edit/delete users)
        // - View all teachers, parents, and kitchen staff
        // - System configuration
    }
}