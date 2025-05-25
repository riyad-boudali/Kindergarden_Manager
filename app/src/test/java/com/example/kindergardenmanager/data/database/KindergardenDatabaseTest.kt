package com.example.kindergardenmanager.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Test class for KindergardenDatabase and its migrations
 */
@RunWith(AndroidJUnit4::class)
class KindergardenDatabaseTest {
    
    private lateinit var db: KindergardenDatabase
    
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, KindergardenDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }
    
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
    
    @Test
    fun testDatabaseCreation() = runBlocking {
        // Basic test to verify database creation
        val userDao = db.userDao()
        val classDao = db.classDao()
        
        // Insert some test data
        val admin = User(
            userId = 1,
            username = "testadmin",
            email = "admin@test.com",
            password = "password",
            role = UserRole.ADMIN,
            firstName = "Test",
            lastName = "Admin"
        )
        
        val testClass = KindergartenClass(
            classId = 1,
            className = "Test Class",
            ageRangeStart = 36, // 3 years
            ageRangeEnd = 48,  // 4 years
            teacherId = 2,
            capacity = 20,
            roomNumber = "101",
            description = "Test classroom",
            isActive = true
        )
        
        userDao.insertUser(admin)
        classDao.insertClass(testClass)
        
        // Verify data was inserted
        val retrievedAdmin = userDao.getUserById(1)
        assert(retrievedAdmin?.username == "testadmin")
        
        val retrievedClass = classDao.getClassById(1)
        assert(retrievedClass?.className == "Test Class")
    }
}
