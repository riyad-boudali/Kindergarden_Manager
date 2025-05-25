package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Child
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Adapter for displaying and managing attendance list
 */
class AttendanceAdapter(
    private val context: Context,
    private var children: List<Child>,
    private val attendanceListener: AttendanceListener
) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    // Map to hold current attendance status
    private val attendanceStatus = mutableMapOf<Long, Boolean>() // childId to isPresent
    
    // Interface for attendance events
    interface AttendanceListener {
        fun onAttendanceChanged(childId: Long, isPresent: Boolean)
    }
    
    // Initialize all children as absent initially
    init {
        children.forEach { child ->
            attendanceStatus[child.childId] = false // Default to absent
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_attendance, parent, false)
        return AttendanceViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val child = children[position]
        holder.bind(child, attendanceStatus[child.childId] ?: false)
    }
    
    override fun getItemCount(): Int = children.size

    fun updateChildren(newChildren: List<Child>) {
        // When updating children, preserve existing attendance statuses
        newChildren.forEach { child ->
            if (!attendanceStatus.containsKey(child.childId)) {
                attendanceStatus[child.childId] = false // Set default for new children
            }
        }
        
        children = newChildren
        notifyDataSetChanged()
    }
    
    fun setAttendanceStatus(childId: Long, isPresent: Boolean) {
        attendanceStatus[childId] = isPresent
        notifyDataSetChanged()
    }
    
    fun updateAllAttendanceStatuses(statuses: Map<Long, Boolean>) {
        statuses.forEach { (childId, isPresent) ->
            attendanceStatus[childId] = isPresent
        }
        notifyDataSetChanged()
    }
    
    fun getAllAttendanceStatuses(): Map<Long, Boolean> {
        return attendanceStatus.toMap()
    }
    
    // Calculate age in years and months
    private fun calculateAge(birthDate: Date): String {
        val calendar = java.util.Calendar.getInstance()
        val today = calendar.time
        
        val birthCalendar = java.util.Calendar.getInstance()
        birthCalendar.time = birthDate
        
        var years = today.year - birthDate.year
        var months = today.month - birthDate.month
        
        if (months < 0) {
            years--
            months += 12
        }
        
        return if (years == 0) {
            "$months ${if (months == 1) "month" else "months"}"
        } else {
            "$years ${if (years == 1) "year" else "years"}, $months ${if (months == 1) "month" else "months"}"
        }
    }
    
    inner class AttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvChildName: TextView = itemView.findViewById(R.id.tvChildName)
        private val tvChildAge: TextView = itemView.findViewById(R.id.tvChildAge)
        private val cbPresent: CheckBox = itemView.findViewById(R.id.cbPresent)
        
        fun bind(child: Child, isPresent: Boolean) {
            tvChildName.text = "${child.firstName} ${child.lastName}"
            tvChildAge.text = "Age: ${calculateAge(child.birthDate)}"
            
            // Set checkbox without triggering listener
            cbPresent.setOnCheckedChangeListener(null)
            cbPresent.isChecked = isPresent
            
            // Set checkbox listener for attendance tracking
            cbPresent.setOnCheckedChangeListener { _, isChecked ->
                attendanceStatus[child.childId] = isChecked
                attendanceListener.onAttendanceChanged(child.childId, isChecked)
            }
        }
    }
}
