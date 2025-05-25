package com.example.kindergardenmanager.data.repository

import androidx.lifecycle.LiveData
import com.example.kindergardenmanager.data.dao.ChildDao
import com.example.kindergardenmanager.data.model.Child
import java.util.Date

/**
 * Repository for handling children operations
 */
class ChildRepository(private val childDao: ChildDao) {

    suspend fun addChild(child: Child): Long {
        return childDao.insertChild(child)
    }
    
    suspend fun updateChild(child: Child) {
        childDao.updateChild(child)
    }
    
    suspend fun deleteChild(child: Child) {
        childDao.deleteChild(child)
    }
    
    suspend fun getChildById(childId: Long): Child? {
        return childDao.getChildById(childId)
    }
    
    fun getChildrenByParentId(parentId: Long): LiveData<List<Child>> {
        return childDao.getChildrenByParentId(parentId)
    }
    
    fun getChildrenByClassId(classId: Long): LiveData<List<Child>> {
        return childDao.getChildrenByClassId(classId)
    }
    
    fun getAllChildren(): LiveData<List<Child>> {
        return childDao.getAllChildren()
    }
    
    fun getActiveChildren(): LiveData<List<Child>> {
        return childDao.getActiveChildren()
    }
    
    /**
     * Get the count of children enrolled in a specific class
     * @param classId The ID of the class
     * @return The number of children currently enrolled in the class
     */
    suspend fun getChildrenCountByClassId(classId: Long): Int {
        return childDao.getChildrenCountByClassId(classId)
    }
}
