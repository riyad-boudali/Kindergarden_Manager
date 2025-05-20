package com.example.kindergardenmanager.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.UserRepository
import kotlinx.coroutines.launch

/**
 * Result of authentication operations
 */
sealed class AuthResult {
    data class Success(val user: User) : AuthResult()
    data class Error(val message: String) : AuthResult()
    object Loading : AuthResult()
}

/**
 * ViewModel for authentication operations
 */
class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {
    
    private val _authResult = MutableLiveData<AuthResult>()
    val authResult: LiveData<AuthResult> = _authResult
    
    /**
     * Attempt to log in a user
     */
    fun login(emailOrUsername: String, password: String) {
        _authResult.value = AuthResult.Loading
        
        if (emailOrUsername.isBlank() || password.isBlank()) {
            _authResult.value = AuthResult.Error("Email/username and password cannot be empty")
            return
        }
        
        viewModelScope.launch {
            val user = userRepository.login(emailOrUsername, password)
            
            if (user != null) {
                if (!user.isActive) {
                    _authResult.value = AuthResult.Error("Account is inactive. Please contact administrator.")
                } else {
                    _authResult.value = AuthResult.Success(user)
                }
            } else {
                _authResult.value = AuthResult.Error("Invalid credentials")
            }
        }
    }
    
    /**
     * Register a new user
     */
    fun register(
        username: String,
        email: String,
        password: String,
        confirmPassword: String,
        role: UserRole,
        firstName: String,
        lastName: String,
        phoneNumber: String? = null
    ) {
        _authResult.value = AuthResult.Loading
        
        // Basic validation
        if (username.isBlank() || email.isBlank() || password.isBlank() || firstName.isBlank() || lastName.isBlank()) {
            _authResult.value = AuthResult.Error("All fields must be filled")
            return
        }
        
        if (password != confirmPassword) {
            _authResult.value = AuthResult.Error("Passwords do not match")
            return
        }
        
        if (password.length < 6) {
            _authResult.value = AuthResult.Error("Password must be at least 6 characters")
            return
        }
        
        viewModelScope.launch {
            // Check if email or username is already taken
            val existingUserByEmail = userRepository.getUserByEmail(email)
            if (existingUserByEmail != null) {
                _authResult.value = AuthResult.Error("Email is already registered")
                return@launch
            }
            
            val existingUserByUsername = userRepository.getUserByUsername(username)
            if (existingUserByUsername != null) {
                _authResult.value = AuthResult.Error("Username is already taken")
                return@launch
            }
            
            // Create new user
            val newUser = User(
                username = username,
                email = email,
                password = password, // In production, this should be hashed
                role = role,
                firstName = firstName,
                lastName = lastName,
                phoneNumber = phoneNumber
            )
            
            try {
                val userId = userRepository.registerUser(newUser)
                val createdUser = newUser.copy(userId = userId)
                _authResult.value = AuthResult.Success(createdUser)
            } catch (e: Exception) {
                _authResult.value = AuthResult.Error("Registration failed: ${e.message}")
            }
        }
    }
    
    /**
     * Clear the current authentication result
     */
    fun clearAuthResult() {
        _authResult.value = null
    }
}
