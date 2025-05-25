package com.example.kindergardenmanager.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "messages",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["senderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["recipientId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("senderId"),
        Index("recipientId")
    ]
)
data class Message(
    @PrimaryKey(autoGenerate = true)
    val messageId: Long = 0,
    val senderId: Long,
    val recipientId: Long,
    val title: String,
    val content: String,
    val timestamp: Date = Date(),
    val isRead: Boolean = false
)
