package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.widget.TextView
import com.example.kindergardenmanager.R

/**
 * Dashboard for Teacher users
 */
class TeacherDashboardActivity : BaseDashboardActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_dashboard)
        
        // Set title
        title = getString(R.string.teacher_dashboard)
        
        // Get user details
        val userDetails = sessionManager.getUserDetails()
        val firstName = userDetails[SessionManager.KEY_FIRST_NAME] ?: ""
        val lastName = userDetails[SessionManager.KEY_LAST_NAME] ?: ""
        
        // Display welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "${getString(R.string.welcome)}, $firstName $lastName!"
        
        // Initialize UI components and functionality specific to Teacher role
        setupTeacherFunctionality()
    }
    
    private fun setupTeacherFunctionality() {
        // TODO: Implement Teacher-specific functionality
        // - View assigned classes and students
        // - Take attendance
        // - Record activities
        // - Communicate with parents
    }
}