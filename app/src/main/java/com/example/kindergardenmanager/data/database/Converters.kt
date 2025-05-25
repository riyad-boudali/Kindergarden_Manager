package com.example.kindergardenmanager.data.database

import androidx.room.TypeConverter
import com.example.kindergardenmanager.data.model.UserRole
import java.util.Date

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
    
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
