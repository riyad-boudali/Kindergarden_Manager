package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.util.SessionManager

/**
 * Base dashboard activity that provides common functionality for all role-specific dashboards
 */
abstract class BaseDashboardActivity : AppCompatActivity() {
    
    protected lateinit var sessionManager: SessionManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize session manager
        sessionManager = SessionManager(this)
        
        // If user is not logged in, redirect to login
        if (!sessionManager.isLoggedIn()) {
            navigateToLogin()
            return
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    /**
     * Set up toolbar with back button
     */
    protected fun setupToolbar(toolbar: Toolbar, title: String = "") {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(title.isNotEmpty())
            this.title = title
        }
        
        toolbar.setNavigationOnClickListener {
            // Using the onBackPressedDispatcher instead of deprecated onBackPressed
            onBackPressedDispatcher.onBackPressed()
        }
    }
    
    /**
     * Logout the user and navigate to login screen
     */
    protected fun logout() {
        sessionManager.logoutUser()
        navigateToLogin()
    }
    
    /**
     * Navigate to the login screen
     */
    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
    
    /**
     * Set up the 'Sign Out' button functionality
     */
    protected fun setupSignOutButton(signOutButton: Button) {
        signOutButton.setOnClickListener {
            logout()
        }
    }
}
