package com.example.kindergardenmanager.ui.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.util.SessionManager

/**
 * Application Settings Activity for Kindergarten Manager
 * Only accessible by admin users
 */
class AppSettingsActivity : AppCompatActivity() {
    
    private lateinit var sessionManager: SessionManager
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var switchNotifications: Switch
    private lateinit var switchDarkMode: Switch
    
    companion object {
        private const val PREFS_NAME = "KindergardenPrefs"
        private const val KEY_NOTIFICATIONS = "notifications_enabled"
        private const val KEY_DARK_MODE = "dark_mode_enabled"
        private const val APP_VERSION = "1.0.0"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_settings)
        
        // Initialize session manager
        sessionManager = SessionManager(this)
        
        // Check if user is admin
        if (sessionManager.getUserRole() != UserRole.ADMIN) {
            Toast.makeText(this, "Unauthorized access", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        
        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Application Settings"
        
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        
        // Initialize shared preferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        
        // Initialize UI components
        initializeViews()
        
        // Load saved settings
        loadSettings()
        
        // Set up button click listeners
        setupButtonListeners()
    }
    
    private fun initializeViews() {
        // Get references to UI elements
        switchNotifications = findViewById(R.id.switchNotifications)
        switchDarkMode = findViewById(R.id.switchDarkMode)
        
        // Set app version
        val tvAppVersion = findViewById<TextView>(R.id.tvAppVersion)
        tvAppVersion.text = "Version: $APP_VERSION"
    }
    
    private fun loadSettings() {
        // Load notification setting
        val notificationsEnabled = sharedPreferences.getBoolean(KEY_NOTIFICATIONS, true)
        switchNotifications.isChecked = notificationsEnabled
        
        // Load dark mode setting
        val darkModeEnabled = sharedPreferences.getBoolean(KEY_DARK_MODE, false)
        switchDarkMode.isChecked = darkModeEnabled
    }
    
    private fun setupButtonListeners() {
        // Save settings button
        val btnSaveSettings = findViewById<Button>(R.id.btnSaveSettings)
        btnSaveSettings.setOnClickListener {
            saveSettings()
        }
        
        // Backup data button
        val btnBackupData = findViewById<Button>(R.id.btnBackupData)
        btnBackupData.setOnClickListener {
            backupData()
        }
        
        // Restore data button
        val btnRestoreData = findViewById<Button>(R.id.btnRestoreData)
        btnRestoreData.setOnClickListener {
            restoreData()
        }
        
        // Check for updates button
        val btnCheckUpdates = findViewById<Button>(R.id.btnCheckUpdates)
        btnCheckUpdates.setOnClickListener {
            checkForUpdates()
        }
    }
    
    private fun saveSettings() {
        // Get current switch states
        val notificationsEnabled = switchNotifications.isChecked
        val darkModeEnabled = switchDarkMode.isChecked
        
        // Save to shared preferences
        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_NOTIFICATIONS, notificationsEnabled)
        editor.putBoolean(KEY_DARK_MODE, darkModeEnabled)
        editor.apply()
        
        // Apply dark mode if changed
        // Note: In a real app, you would implement a proper theme switching mechanism
        
        Toast.makeText(this, "Settings saved successfully", Toast.LENGTH_SHORT).show()
    }
    
    private fun backupData() {
        // In a real app, this would implement backup functionality
        // For example, exporting database to a file or cloud storage
        Toast.makeText(this, "Data backup started", Toast.LENGTH_SHORT).show()
        
        // Simulate backup process
        // In a real app, this would be done in a background thread
        Toast.makeText(this, "Data backup completed", Toast.LENGTH_SHORT).show()
    }
    
    private fun restoreData() {
        // In a real app, this would implement restore functionality
        // For example, importing database from a file or cloud storage
        Toast.makeText(this, "Data restore started", Toast.LENGTH_SHORT).show()
        
        // Simulate restore process
        // In a real app, this would be done in a background thread
        Toast.makeText(this, "Data restore completed", Toast.LENGTH_SHORT).show()
    }
    
    private fun checkForUpdates() {
        // In a real app, this would check for updates from a server
        // For example, comparing local version with server version
        Toast.makeText(this, "Checking for updates...", Toast.LENGTH_SHORT).show()
        
        // Simulate update check
        // In a real app, this would be done in a background thread
        Toast.makeText(this, "You have the latest version: $APP_VERSION", Toast.LENGTH_SHORT).show()
    }
}
