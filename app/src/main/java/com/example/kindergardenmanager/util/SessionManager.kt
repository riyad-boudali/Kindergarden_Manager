package com.example.kindergardenmanager.util

import android.content.Context
import android.content.SharedPreferences
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole

/**
 * SessionManager handles user session data like authentication state
 */
class SessionManager(context: Context) {
    
    private val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor = preferences.edit()
    
    companion object {
        const val PREF_NAME = "KindergartenAppSession"
        const val KEY_IS_LOGGED_IN = "isLoggedIn"
        const val KEY_USER_ID = "userId"
        const val KEY_USERNAME = "username"
        const val KEY_EMAIL = "email"
        const val KEY_FIRST_NAME = "firstName"
        const val KEY_LAST_NAME = "lastName"
        const val KEY_ROLE = "role"
    }
    
    /**
     * Save user login session
     */
    fun createLoginSession(user: User) {
        editor.apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putLong(KEY_USER_ID, user.userId)
            putString(KEY_USERNAME, user.username)
            putString(KEY_EMAIL, user.email)
            putString(KEY_FIRST_NAME, user.firstName)
            putString(KEY_LAST_NAME, user.lastName)
            putString(KEY_ROLE, user.role.name)
            apply()
        }
    }
    
    /**
     * Check if user is logged in
     */
    fun isLoggedIn(): Boolean {
        return preferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }
    
    /**
     * Get logged in user details
     */
    fun getUserDetails(): HashMap<String, String?> {
        val user = HashMap<String, String?>()
        user[KEY_USER_ID] = preferences.getLong(KEY_USER_ID, -1).toString()
        user[KEY_USERNAME] = preferences.getString(KEY_USERNAME, null)
        user[KEY_EMAIL] = preferences.getString(KEY_EMAIL, null)
        user[KEY_FIRST_NAME] = preferences.getString(KEY_FIRST_NAME, null)
        user[KEY_LAST_NAME] = preferences.getString(KEY_LAST_NAME, null)
        user[KEY_ROLE] = preferences.getString(KEY_ROLE, null)
        
        return user
    }
    
    /**
     * Get current user role
     */
    fun getUserRole(): UserRole? {
        val roleStr = preferences.getString(KEY_ROLE, null)
        return if (roleStr != null) UserRole.valueOf(roleStr) else null
    }
    
    /**
     * Get current user ID
     */
    fun getUserId(): Long {
        return preferences.getLong(KEY_USER_ID, -1)
    }
    
    /**
     * Clear user session data
     */
    fun logoutUser() {
        editor.clear()
        editor.apply()
    }
}
