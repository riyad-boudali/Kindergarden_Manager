package com.example.kindergardenmanager.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Class entity representing a class in the kindergarten
 */
@Entity(tableName = "classes")
data class KindergartenClass(
    @PrimaryKey(autoGenerate = true)
    val classId: Long = 0,
    
    val className: String,
    val ageRangeStart: Int, // Age in months
    val ageRangeEnd: Int,   // Age in months
    val teacherId: Long,    // Foreign key to User
    val capacity: Int,
    val roomNumber: String? = null,
    val description: String? = null,
    val isActive: Boolean = true
)
