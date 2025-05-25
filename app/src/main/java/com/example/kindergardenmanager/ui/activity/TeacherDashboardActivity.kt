package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.util.SessionManager

/**
 * Dashboard for Teacher users
 */
class TeacherDashboardActivity : BaseDashboardActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_dashboard)
        
        // Set up toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setupToolbar(toolbar, getString(R.string.teacher_dashboard))
        
        // Get user details
        val userDetails = sessionManager.getUserDetails()
        val firstName = userDetails[SessionManager.KEY_FIRST_NAME] ?: ""
        val lastName = userDetails[SessionManager.KEY_LAST_NAME] ?: ""
        
        // Display welcome message
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "${getString(R.string.welcome)}, $firstName $lastName!"
        
        // Initialize UI components and functionality specific to Teacher role
        setupTeacherFunctionality()

        // Set up 'Sign Out' button
        val btnSignOut = findViewById<Button>(R.id.btnSignOut)
        setupSignOutButton(btnSignOut)
    }
    
    private fun setupTeacherFunctionality() {
        // Set up 'My Classes' button
        val btnViewClasses = findViewById<Button>(R.id.btnViewClasses)
        btnViewClasses.setOnClickListener {
            val intent = Intent(this, ViewClassesActivity::class.java)
            startActivity(intent)
        }
        
        // Set up 'Take Attendance' button
        val btnAttendance = findViewById<Button>(R.id.btnAttendance)
        btnAttendance.setOnClickListener {
            val intent = Intent(this, ViewClassesForAttendanceActivity::class.java)
            startActivity(intent)
        }
        
        // Set up 'Messages' button
        val btnMessages = findViewById<Button>(R.id.btnMessages)
        btnMessages.setOnClickListener {
            // TODO: Implement messaging functionality
        }
        
        // Set up 'Create Announcement' button
        val btnAnnouncements = findViewById<Button>(R.id.btnAnnouncements)
        btnAnnouncements.setOnClickListener {
            // TODO: Implement announcements functionality
        }
    }
}