package com.example.kindergardenmanager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kindergardenmanager.data.model.Message

@Dao
interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertMessage(message: Message): Long
    
    @Update
    suspend fun updateMessage(message: Message)
    
    @Delete
    suspend fun deleteMessage(message: Message)
    
    @Query("SELECT * FROM messages WHERE recipientId = :userId ORDER BY timestamp DESC")
    fun getMessagesForUser(userId: Long): LiveData<List<Message>>
    
    @Query("SELECT * FROM messages WHERE messageId = :messageId")
    suspend fun getMessageById(messageId: Long): Message?
    
    @Query("UPDATE messages SET isRead = 1 WHERE messageId = :messageId")
    suspend fun markMessageAsRead(messageId: Long)
}
