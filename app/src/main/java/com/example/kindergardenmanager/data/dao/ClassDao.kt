package com.example.kindergardenmanager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.kindergardenmanager.data.model.KindergartenClass

@Dao
interface ClassDao {
    
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertClass(kindergartenClass: KindergartenClass): Long
    
    @Update
    suspend fun updateClass(kindergartenClass: KindergartenClass)
    
    @Delete
    suspend fun deleteClass(kindergartenClass: KindergartenClass)
    
    @Query("SELECT * FROM classes WHERE classId = :classId")
    suspend fun getClassById(classId: Long): KindergartenClass?
    
    @Query("SELECT * FROM classes WHERE teacherId = :teacherId")
    fun getClassesByTeacherId(teacherId: Long): LiveData<List<KindergartenClass>>
    
    @Query("SELECT * FROM classes")
    fun getAllClasses(): LiveData<List<KindergartenClass>>
    
    @Query("SELECT COUNT(*) FROM children WHERE classId = :classId")
    fun getChildCountForClass(classId: Long): LiveData<Int>
    
    @Query("SELECT * FROM classes WHERE isActive = 1")
    fun getActiveClasses(): LiveData<List<KindergartenClass>>
}
