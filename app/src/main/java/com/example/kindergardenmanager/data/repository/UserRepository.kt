package com.example.kindergardenmanager.data.repository

import com.example.kindergardenmanager.data.dao.UserDao
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole

/**
 * Repository for handling user authentication and user management
 */
class UserRepository(private val userDao: UserDao) {

    suspend fun login(emailOrUsername: String, password: String): User? {
        return userDao.login(emailOrUsername, password)
    }
    
    suspend fun registerUser(user: User): Long {
        return userDao.insertUser(user)
    }
    
    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
    
    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }
    
    suspend fun getUserById(userId: Long): User? {
        return userDao.getUserById(userId)
    }
    
    fun getUsersByRole(role: UserRole) = userDao.getUsersByRole(role)
    
    fun getAllUsers() = userDao.getAllUsers()
    
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
}
