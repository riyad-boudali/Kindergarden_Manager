package com.example.kindergardenmanager.data.repository

import androidx.lifecycle.LiveData
import com.example.kindergardenmanager.data.dao.AttendanceDao
import com.example.kindergardenmanager.data.model.Attendance
import java.util.Date

/**
 * Repository class for handling attendance-related operations
 */
class AttendanceRepository(private val attendanceDao: AttendanceDao) {
    
    suspend fun addAttendance(attendance: Attendance): Long {
        return attendanceDao.insertAttendance(attendance)
    }
    
    suspend fun updateAttendance(attendance: Attendance) {
        attendanceDao.updateAttendance(attendance)
    }
    
    suspend fun deleteAttendance(attendance: Attendance) {
        attendanceDao.deleteAttendance(attendance)
    }
    
    suspend fun getAttendanceById(attendanceId: Long): Attendance? {
        return attendanceDao.getAttendanceById(attendanceId)
    }
    
    fun getAttendanceByChildId(childId: Long): LiveData<List<Attendance>> {
        return attendanceDao.getAttendanceByChildId(childId)
    }
    
    fun getAttendanceByClassAndDate(classId: Long, date: Date): LiveData<List<Attendance>> {
        return attendanceDao.getAttendanceByClassAndDate(classId, date)
    }
    
    suspend fun getAttendanceByChildAndDate(childId: Long, date: Date): Attendance? {
        return attendanceDao.getAttendanceByChildAndDate(childId, date)
    }
    
    fun getAttendanceByClassAndDateRange(classId: Long, startDate: Date, endDate: Date): LiveData<List<Attendance>> {
        return attendanceDao.getAttendanceByClassAndDateRange(classId, startDate, endDate)
    }
    
    fun getChildPresentDaysCount(childId: Long): LiveData<Int> {
        return attendanceDao.getChildPresentDaysCount(childId)
    }
    
    suspend fun getAttendanceWithChildInfo(classId: Long, date: Date): List<Attendance> {
        return attendanceDao.getAttendanceWithChildInfo(classId, date)
    }
    
    suspend fun deleteAttendanceForClassAndDate(classId: Long, date: Date) {
        attendanceDao.deleteAttendanceForClassAndDate(classId, date)
    }
    
    suspend fun markAttendance(
        classId: Long, 
        childId: Long, 
        date: Date, 
        isPresent: Boolean, 
        notes: String? = null
    ) {
        val attendance = Attendance(
            childId = childId,
            classId = classId,
            date = date,
            isPresent = isPresent,
            notes = notes
        )
        attendanceDao.insertAttendance(attendance)
    }
}
