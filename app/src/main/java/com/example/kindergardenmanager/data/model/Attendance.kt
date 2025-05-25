package com.example.kindergardenmanager.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Entity representing a student's attendance record
 */
@Entity(
    tableName = "attendance",
    foreignKeys = [
        ForeignKey(
            entity = Child::class,
            parentColumns = ["childId"],
            childColumns = ["childId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = KindergartenClass::class,
            parentColumns = ["classId"],
            childColumns = ["classId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("childId"),
        Index("classId"),
        Index(value = ["childId", "date"], unique = true)
    ]
)
data class Attendance(
    @PrimaryKey(autoGenerate = true)
    val attendanceId: Long = 0,
    
    val childId: Long,
    val classId: Long,
    val date: Date,
    val isPresent: Boolean,
    val notes: String? = null
)

/**
 * Data class for attendance with child information
 * This is used for UI display
 */
data class AttendanceWithChild(
    val attendance: Attendance,
    val childFirstName: String,
    val childLastName: String
)
