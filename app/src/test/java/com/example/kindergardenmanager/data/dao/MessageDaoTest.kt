package com.example.kindergardenmanager.data.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.kindergardenmanager.data.database.KindergardenDatabase
import com.example.kindergardenmanager.data.model.Message
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.Date

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class MessageDaoTest {
    
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    
    private lateinit var database: KindergardenDatabase
    private lateinit var messageDao: MessageDao
    private lateinit var userDao: UserDao
    private lateinit var testSender: User
    private lateinit var testRecipient: User

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, KindergardenDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        messageDao = database.messageDao()
        userDao = database.userDao()

        // Create test users
        runTest {
            testSender = User(
                username = "teacher1",
                email = "teacher1@test.com",
                password = "password",
                role = UserRole.TEACHER,
                firstName = "Test",
                lastName = "Teacher"
            )
            testRecipient = User(
                username = "parent1",
                email = "parent1@test.com",
                password = "password",
                role = UserRole.PARENT,
                firstName = "Test",
                lastName = "Parent"
            )

            testSender = User(testSender.copy(userId = userDao.insertUser(testSender)))
            testRecipient = User(testRecipient.copy(userId = userDao.insertUser(testRecipient)))
        }
    }

    @After
    fun cleanup() {
        database.close()
    }

    @Test
    fun insertAndRetrieveMessage() = runTest {
        // Create a test message
        val message = Message(
            senderId = testSender.userId,
            recipientId = testRecipient.userId,
            title = "Test Message",
            content = "This is a test message",
            timestamp = Date(),
            isRead = false
        )

        // Insert the message
        val messageId = messageDao.insertMessage(message)

        // Retrieve the message
        val retrievedMessage = messageDao.getMessageById(messageId)

        // Verify the message was correctly stored
        assertEquals(message.title, retrievedMessage?.title)
        assertEquals(message.content, retrievedMessage?.content)
        assertEquals(message.senderId, retrievedMessage?.senderId)
        assertEquals(message.recipientId, retrievedMessage?.recipientId)
        assertEquals(false, retrievedMessage?.isRead)
    }

    @Test
    fun markMessageAsRead() = runTest {
        // Create and insert a test message
        val message = Message(
            senderId = testSender.userId,
            recipientId = testRecipient.userId,
            title = "Test Message",
            content = "This is a test message",
            timestamp = Date(),
            isRead = false
        )
        val messageId = messageDao.insertMessage(message)

        // Mark the message as read
        messageDao.markMessageAsRead(messageId)

        // Retrieve the message and verify it's marked as read
        val retrievedMessage = messageDao.getMessageById(messageId)
        assertEquals(true, retrievedMessage?.isRead)
    }

    @Test
    fun deleteMessage() = runTest {
        // Create and insert a test message
        val message = Message(
            senderId = testSender.userId,
            recipientId = testRecipient.userId,
            title = "Test Message",
            content = "This is a test message",
            timestamp = Date(),
            isRead = false
        )
        val messageId = messageDao.insertMessage(message)

        // Delete the message
        messageDao.deleteMessage(message.copy(messageId = messageId))

        // Try to retrieve the message and verify it's deleted
        val retrievedMessage = messageDao.getMessageById(messageId)
        assertNull(retrievedMessage)
    }

    @Test
    fun getMessagesForUser() = runTest {
        // Create multiple test messages
        val message1 = Message(
            senderId = testSender.userId,
            recipientId = testRecipient.userId,
            title = "Test Message 1",
            content = "This is test message 1",
            timestamp = Date(System.currentTimeMillis() - 1000), // 1 second ago
            isRead = false
        )
        val message2 = Message(
            senderId = testSender.userId,
            recipientId = testRecipient.userId,
            title = "Test Message 2",
            content = "This is test message 2",
            timestamp = Date(), // now
            isRead = false
        )

        // Insert messages
        messageDao.insertMessage(message1)
        messageDao.insertMessage(message2)

        // Get messages for recipient
        val messages = messageDao.getMessagesForUser(testRecipient.userId).getOrAwaitValue()

        // Verify we got both messages in correct order (newest first)
        assertEquals(2, messages.size)
        assertEquals("Test Message 2", messages[0].title)
        assertEquals("Test Message 1", messages[1].title)
    }
}
