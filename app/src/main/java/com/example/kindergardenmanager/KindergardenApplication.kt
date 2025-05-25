package com.example.kindergardenmanager

import android.app.Application
import com.example.kindergardenmanager.data.database.KindergardenDatabase
import com.example.kindergardenmanager.data.repository.AttendanceRepository
import com.example.kindergardenmanager.data.repository.ChildRepository
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.data.repository.MessageRepository
import com.example.kindergardenmanager.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Application class for global application state
 */
class KindergardenApplication : Application() {
    
    private val applicationScope = CoroutineScope(SupervisorJob())
    
    // Lazy initialize database
    val database by lazy { 
        KindergardenDatabase.getDatabase(this, applicationScope) 
    }
    
    // Lazy initialize repositories
    val userRepository by lazy {
        UserRepository(database.userDao())
    }
    
    val classRepository by lazy {
        ClassRepository(database.classDao())
    }
    
    val childRepository by lazy {
        ChildRepository(database.childDao())
    }
    
    val attendanceRepository by lazy {
        AttendanceRepository(database.attendanceDao())
    }

    val messageRepository by lazy {
        MessageRepository(database.messageDao())
    }
}
