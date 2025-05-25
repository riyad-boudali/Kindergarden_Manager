package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.User

/**
 * Adapter for displaying classes in admin view with edit/delete options
 */
class ClassAdminAdapter(
    private val context: Context,
    private var classes: List<KindergartenClass>,
    private val classClickListener: ClassAdminClickListener,
    private val teacherMap: Map<Long, User> = emptyMap(),
    private val studentCountMap: Map<Long, Int> = emptyMap()
) : RecyclerView.Adapter<ClassAdminAdapter.ClassViewHolder>() {

    // Interface for class actions
    interface ClassAdminClickListener {
        fun onClassClicked(kindergartenClass: KindergartenClass)
        fun onEditClass(kindergartenClass: KindergartenClass)
        fun onDeleteClass(kindergartenClass: KindergartenClass)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_class_admin, parent, false)
        return ClassViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val kindergartenClass = classes[position]
        holder.bind(kindergartenClass)
    }
    
    override fun getItemCount(): Int = classes.size
    
    fun updateClasses(newClasses: List<KindergartenClass>) {
        classes = newClasses
        notifyDataSetChanged()
    }
    
    fun updateTeacherInfo(newTeacherMap: Map<Long, User>) {
        (teacherMap as MutableMap).clear()
        (teacherMap as MutableMap).putAll(newTeacherMap)
        notifyDataSetChanged()
    }
    
    fun updateStudentCount(classId: Long, count: Int) {
        (studentCountMap as MutableMap)[classId] = count
        notifyDataSetChanged()
    }
    
    inner class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvClassName: TextView = itemView.findViewById(R.id.tvClassName)
        private val tvAgeRange: TextView = itemView.findViewById(R.id.tvAgeRange)
        private val tvTeacher: TextView = itemView.findViewById(R.id.tvTeacher)
        private val tvCapacityInfo: TextView = itemView.findViewById(R.id.tvCapacityInfo)
        private val btnEdit: ImageButton = itemView.findViewById(R.id.btnEdit)
        private val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
        
        fun bind(kindergartenClass: KindergartenClass) {
            tvClassName.text = kindergartenClass.className
            
            // Age range in years
            val ageStartYears = kindergartenClass.ageRangeStart / 12
            val ageEndYears = kindergartenClass.ageRangeEnd / 12
            tvAgeRange.text = "Age: $ageStartYears-$ageEndYears years"
            
            // Teacher info
            val teacher = teacherMap[kindergartenClass.teacherId]
            tvTeacher.text = if (teacher != null) {
                "Teacher: ${teacher.firstName} ${teacher.lastName}"
            } else {
                "Teacher: Not assigned"
            }
            
            // Capacity info
            val studentsCount = studentCountMap[kindergartenClass.classId] ?: 0
            tvCapacityInfo.text = "Students: $studentsCount/${kindergartenClass.capacity}"
            
            // Set click listeners
            itemView.setOnClickListener {
                classClickListener.onClassClicked(kindergartenClass)
            }
            
            btnEdit.setOnClickListener {
                classClickListener.onEditClass(kindergartenClass)
            }
            
            btnDelete.setOnClickListener {
                classClickListener.onDeleteClass(kindergartenClass)
            }
        }
    }
}
