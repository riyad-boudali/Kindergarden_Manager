package com.example.kindergardenmanager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole

@Dao
interface UserDao {
    
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User): Long
    
    @Update
    suspend fun updateUser(user: User)
    
    @Delete
    suspend fun deleteUser(user: User)
    
    @Query("SELECT * FROM users WHERE userId = :userId")
    suspend fun getUserById(userId: Long): User?
    
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?
    
    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?
    
    @Query("SELECT * FROM users WHERE email = :emailOrUsername OR username = :emailOrUsername LIMIT 1")
    suspend fun getUserByEmailOrUsername(emailOrUsername: String): User?
    
    @Query("SELECT * FROM users WHERE role = :role")
    fun getUsersByRole(role: UserRole): LiveData<List<User>>
    
    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>
    
    /**
     * Authentication method to verify login credentials
     */
    @Query("SELECT * FROM users WHERE (email = :emailOrUsername OR username = :emailOrUsername) AND password = :password LIMIT 1")
    suspend fun login(emailOrUsername: String, password: String): User?
}
