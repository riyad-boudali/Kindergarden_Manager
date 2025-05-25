package com.example.kindergardenmanager.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Child entity representing a child in the kindergarten
 */
@Entity(
    tableName = "children",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["parentId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = KindergartenClass::class,
            parentColumns = ["classId"],
            childColumns = ["classId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("parentId"),
        Index("classId")
    ]
)
data class Child(
    @PrimaryKey(autoGenerate = true)
    val childId: Long = 0,
    
    val firstName: String,
    val lastName: String,
    val birthDate: Date,
    val parentId: Long,    // Foreign key to User (parent)
    val classId: Long?,    // Foreign key to KindergartenClass
    val gender: String,
    val allergies: String? = null,
    val medicalNotes: String? = null,
    val emergencyContact: String? = null,
    val enrollmentDate: Date = Date(),
    val isActive: Boolean = true
)
