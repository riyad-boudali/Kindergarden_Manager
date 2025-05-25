package com.example.kindergardenmanager.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.kindergardenmanager.data.model.Attendance
import java.util.Date

@Dao
interface AttendanceDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(attendance: Attendance): Long
    
    @Update
    suspend fun updateAttendance(attendance: Attendance)
    
    @Delete
    suspend fun deleteAttendance(attendance: Attendance)
    
    @Query("SELECT * FROM attendance WHERE attendanceId = :attendanceId")
    suspend fun getAttendanceById(attendanceId: Long): Attendance?
    
    @Query("SELECT * FROM attendance WHERE childId = :childId")
    fun getAttendanceByChildId(childId: Long): LiveData<List<Attendance>>
    
    @Query("SELECT * FROM attendance WHERE classId = :classId AND date = :date")
    fun getAttendanceByClassAndDate(classId: Long, date: Date): LiveData<List<Attendance>>
    
    @Query("SELECT * FROM attendance WHERE childId = :childId AND date = :date")
    suspend fun getAttendanceByChildAndDate(childId: Long, date: Date): Attendance?
    
    @Query("SELECT * FROM attendance WHERE classId = :classId AND date BETWEEN :startDate AND :endDate")
    fun getAttendanceByClassAndDateRange(classId: Long, startDate: Date, endDate: Date): LiveData<List<Attendance>>
    
    @Query("SELECT COUNT(*) FROM attendance WHERE childId = :childId AND isPresent = 1")
    fun getChildPresentDaysCount(childId: Long): LiveData<Int>
    
    // Room doesn't support complex returns like Map<Entity, Pair<String, String>>
    // Using a simple query for attendance instead
    @Query("SELECT * FROM attendance WHERE classId = :classId AND date = :date")
    suspend fun getAttendanceWithChildInfo(classId: Long, date: Date): List<Attendance>
    
    @Transaction
    @Query("DELETE FROM attendance WHERE classId = :classId AND date = :date")
    suspend fun deleteAttendanceForClassAndDate(classId: Long, date: Date)
}
