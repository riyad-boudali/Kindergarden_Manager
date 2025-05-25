package com.example.kindergardenmanager.data.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kindergardenmanager.data.database.KindergardenDatabase
import com.example.kindergardenmanager.data.model.Message
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class MessageDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: KindergardenDatabase
    private lateinit var messageDao: MessageDao
    private lateinit var userDao: UserDao
    private lateinit var sender: User
    private lateinit var recipient: User

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            KindergardenDatabase::class.java
        ).build()
        messageDao = database.messageDao()
        userDao = database.userDao()

        // Create test users
        runBlocking {
            sender = User(
                username = "teacher1",
                email = "teacher1@test.com",
                password = "password",
                role = UserRole.TEACHER,
                firstName = "Test",
                lastName = "Teacher"
            )
            val senderId = userDao.insertUser(sender)
            sender = sender.copy(userId = senderId)

            recipient = User(
                username = "parent1",
                email = "parent1@test.com",
                password = "password",
                role = UserRole.PARENT,
                firstName = "Test",
                lastName = "Parent"
            )
            val recipientId = userDao.insertUser(recipient)
            recipient = recipient.copy(userId = recipientId)
        }
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertAndRetrieveMessage() = runBlocking {
        // Create test message
        val message = Message(
            senderId = sender.userId,
            recipientId = recipient.userId,
            title = "Test Message",
            content = "This is a test message"
        )

        // Insert message
        val messageId = messageDao.insertMessage(message)
        assertTrue(messageId > 0)

        // Retrieve message
        val retrievedMessage = messageDao.getMessageById(messageId)
        assertNotNull(retrievedMessage)
        assertEquals(message.title, retrievedMessage?.title)
        assertEquals(message.content, retrievedMessage?.content)
        assertEquals(message.senderId, retrievedMessage?.senderId)
        assertEquals(message.recipientId, retrievedMessage?.recipientId)
        assertFalse(retrievedMessage?.isRead ?: true)
    }

    @Test
    fun markMessageAsRead() = runBlocking {
        // Create and insert test message
        val message = Message(
            senderId = sender.userId,
            recipientId = recipient.userId,
            title = "Test Message",
            content = "This is a test message"
        )
        val messageId = messageDao.insertMessage(message)

        // Mark message as read
        messageDao.markMessageAsRead(messageId)

        // Verify message is marked as read
        val retrievedMessage = messageDao.getMessageById(messageId)
        assertNotNull(retrievedMessage)
        assertTrue(retrievedMessage?.isRead ?: false)
    }

    @Test
    fun deleteMessage() = runBlocking {
        // Create and insert test message
        val message = Message(
            senderId = sender.userId,
            recipientId = recipient.userId,
            title = "Test Message",
            content = "This is a test message"
        )
        val messageId = messageDao.insertMessage(message)

        // Get the inserted message
        val retrievedMessage = messageDao.getMessageById(messageId)
        assertNotNull(retrievedMessage)

        // Delete the message
        messageDao.deleteMessage(retrievedMessage!!)

        // Verify message is deleted
        val deletedMessage = messageDao.getMessageById(messageId)
        assertNull(deletedMessage)
    }

    @Test
    fun getMessagesForUser() = runBlocking {
        // Create several test messages
        val message1 = Message(
            senderId = sender.userId,
            recipientId = recipient.userId,
            title = "Test Message 1",
            content = "This is test message 1"
        )
        val message2 = Message(
            senderId = sender.userId,
            recipientId = recipient.userId,
            title = "Test Message 2",
            content = "This is test message 2"
        )

        // Insert messages
        messageDao.insertMessage(message1)
        messageDao.insertMessage(message2)

        // Get messages for recipient
        var messages: List<Message>? = null
        messageDao.getMessagesForUser(recipient.userId).observeForever { 
            messages = it 
        }

        // Verify messages are retrieved
        assertNotNull(messages)
        assertEquals(2, messages?.size)
        assertEquals("Test Message 1", messages?.get(1)?.title)
        assertEquals("Test Message 2", messages?.get(0)?.title)
    }
}
