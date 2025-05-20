package com.example.kindergardenmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.ui.activity.AdminDashboardActivity
import com.example.kindergardenmanager.ui.activity.KitchenStaffDashboardActivity
import com.example.kindergardenmanager.ui.activity.LoginActivity
import com.example.kindergardenmanager.ui.activity.ParentDashboardActivity
import com.example.kindergardenmanager.ui.activity.TeacherDashboardActivity
import com.example.kindergardenmanager.util.SessionManager

class MainActivity : AppCompatActivity() {
    
    private lateinit var sessionManager: SessionManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize session manager
        sessionManager = SessionManager(this)
        
        // Check if user is logged in
        if (sessionManager.isLoggedIn()) {
            // If logged in, navigate to appropriate dashboard based on role
            navigateToDashboard()
        } else {
            // If not logged in, navigate to login screen
            startActivity(Intent(this, LoginActivity::class.java))
        }
        
        finish() // Finish this activity so it's not in the back stack
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
    }
}
