package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Child
import com.example.kindergardenmanager.data.model.User
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Adapter for displaying children with enrollment actions
 */
class EnrollmentAdapter(
    private val context: Context,
    private var children: List<Child>,
    private val enrollmentListener: EnrollmentListener,
    private val isEnrolled: Boolean,
    private val parentMap: Map<Long, User> = emptyMap()
) : RecyclerView.Adapter<EnrollmentAdapter.EnrollmentViewHolder>() {

    // Interface for enrollment actions
    interface EnrollmentListener {
        fun onEnrollChild(child: Child)
        fun onUnenrollChild(child: Child)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrollmentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_child_enrollment, parent, false)
        return EnrollmentViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: EnrollmentViewHolder, position: Int) {
        val child = children[position]
        holder.bind(child)
    }
    
    override fun getItemCount(): Int = children.size
    
    fun updateChildren(newChildren: List<Child>) {
        children = newChildren
        notifyDataSetChanged()
    }
    
    fun updateParentInfo(newParentMap: Map<Long, User>) {
        (parentMap as MutableMap).clear()
        (parentMap as MutableMap).putAll(newParentMap)
        notifyDataSetChanged()
    }
    
    // Calculate age in years and months
    private fun calculateAge(birthDate: Date): String {
        val today = Calendar.getInstance()
        val birthDay = Calendar.getInstance()
        birthDay.time = birthDate
        
        var years = today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR)
        var months = today.get(Calendar.MONTH) - birthDay.get(Calendar.MONTH)
        
        if (today.get(Calendar.DAY_OF_MONTH) < birthDay.get(Calendar.DAY_OF_MONTH)) {
            months--
        }
        
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
    
    inner class EnrollmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvChildName: TextView = itemView.findViewById(R.id.tvChildName)
        private val tvChildAge: TextView = itemView.findViewById(R.id.tvChildAge)
        private val tvParentInfo: TextView = itemView.findViewById(R.id.tvParentInfo)
        private val btnAction: Button = itemView.findViewById(R.id.btnAction)
        
        fun bind(child: Child) {
            tvChildName.text = "${child.firstName} ${child.lastName}"
            tvChildAge.text = "Age: ${calculateAge(child.birthDate)}"
            
            // Parent info
            val parent = parentMap[child.parentId]
            tvParentInfo.text = if (parent != null) {
                "Parent: ${parent.firstName} ${parent.lastName}"
            } else {
                "Parent: Unknown"
            }
            
            // Set button text and action based on enrollment status
            if (isEnrolled) {
                btnAction.text = "Unenroll"
                btnAction.setOnClickListener {
                    enrollmentListener.onUnenrollChild(child)
                }
            } else {
                btnAction.text = "Enroll"
                btnAction.setOnClickListener {
                    enrollmentListener.onEnrollChild(child)
                }
            }
        }
    }
}
