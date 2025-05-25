package com.example.kindergardenmanager.data.repository

import androidx.lifecycle.LiveData
import com.example.kindergardenmanager.data.dao.MessageDao
import com.example.kindergardenmanager.data.model.Message

class MessageRepository(private val messageDao: MessageDao) {
    
    fun getMessagesForUser(userId: Long): LiveData<List<Message>> {
        return messageDao.getMessagesForUser(userId)
    }
    
    suspend fun markMessageAsRead(messageId: Long) {
        messageDao.markMessageAsRead(messageId)
    }
    
    suspend fun getMessageById(messageId: Long): Message? {
        return messageDao.getMessageById(messageId)
    }
}
