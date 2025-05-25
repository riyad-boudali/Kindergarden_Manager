package com.example.kindergardenmanager.data.repository

import androidx.lifecycle.LiveData
import com.example.kindergardenmanager.data.dao.ClassDao
import com.example.kindergardenmanager.data.model.KindergartenClass

/**
 * Repository for handling classroom operations
 */
class ClassRepository(private val classDao: ClassDao) {

    suspend fun addClass(kindergartenClass: KindergartenClass): Long {
        return classDao.insertClass(kindergartenClass)
    }
    
    suspend fun updateClass(kindergartenClass: KindergartenClass) {
        classDao.updateClass(kindergartenClass)
    }
    
    suspend fun deleteClass(kindergartenClass: KindergartenClass) {
        classDao.deleteClass(kindergartenClass)
    }
    
    suspend fun getClassById(classId: Long): KindergartenClass? {
        return classDao.getClassById(classId)
    }
    
    fun getClassesByTeacherId(teacherId: Long): LiveData<List<KindergartenClass>> {
        return classDao.getClassesByTeacherId(teacherId)
    }
    
    fun getAllClasses(): LiveData<List<KindergartenClass>> {
        return classDao.getAllClasses()
    }
    
    fun getChildCountForClass(classId: Long): LiveData<Int> {
        return classDao.getChildCountForClass(classId)
    }
    
    fun getActiveClasses(): LiveData<List<KindergartenClass>> {
        return classDao.getActiveClasses()
    }
}
