package com.example.kindergardenmanager.data.database

import androidx.room.TypeConverter
import com.example.kindergardenmanager.data.model.UserRole

/**
 * Type converters for Room to handle custom data types
 */
class Converters {
    @TypeConverter
    fun fromUserRole(role: UserRole): String {
        return role.name
    }
    
    @TypeConverter
    fun toUserRole(roleName: String): UserRole {
        return UserRole.valueOf(roleName)
    }
}
