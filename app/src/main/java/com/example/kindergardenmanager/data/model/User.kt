package com.example.kindergardenmanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User roles in the system
 */
enum class UserRole {
    ADMIN,
    TEACHER,
    PARENT,
    KITCHEN_STAFF
}

/**
 * User entity representing a user in the database
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Long = 0,
    
    val username: String,
    val email: String,
    val password: String,  // In a production app, this should be hashed
    val role: UserRole,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String? = null,
    val isActive: Boolean = true
)
