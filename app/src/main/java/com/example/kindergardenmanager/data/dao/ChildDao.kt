package com.example.kindergardenmanager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.kindergardenmanager.data.model.Child

@Dao
interface ChildDao {
    
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertChild(child: Child): Long
    
    @Update
    suspend fun updateChild(child: Child)
    
    @Delete
    suspend fun deleteChild(child: Child)
    
    @Query("SELECT * FROM children WHERE childId = :childId")
    suspend fun getChildById(childId: Long): Child?
    
    @Query("SELECT * FROM children WHERE parentId = :parentId")
    fun getChildrenByParentId(parentId: Long): LiveData<List<Child>>
    
    @Query("SELECT * FROM children WHERE classId = :classId")
    fun getChildrenByClassId(classId: Long): LiveData<List<Child>>
    
    @Query("SELECT * FROM children")
    fun getAllChildren(): LiveData<List<Child>>
    
    @Query("SELECT * FROM children WHERE isActive = 1")
    fun getActiveChildren(): LiveData<List<Child>>
    
    @Query("SELECT COUNT(*) FROM children WHERE classId = :classId")
    suspend fun getChildrenCountByClassId(classId: Long): Int
}
