package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.KindergartenClass

class ClassListAdapter(
    private val context: Context,
    private var classes: List<KindergartenClass>,
    private val listener: ClassClickListener
) : RecyclerView.Adapter<ClassListAdapter.ClassViewHolder>() {
    
    // Map to store child counts for each class
    private val childCountMap = mutableMapOf<Long, Int>()
    
    interface ClassClickListener {
        fun onClassClicked(kindergartenClass: KindergartenClass)
    }
    
    inner class ClassViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvClassName: TextView = view.findViewById(R.id.tvClassName)
        val tvAgeRange: TextView = view.findViewById(R.id.tvAgeRange)
        val tvKidsCount: TextView = view.findViewById(R.id.tvKidsCount)
        val tvRoomNumber: TextView = view.findViewById(R.id.tvRoomNumber)
        val btnViewDetails: Button = view.findViewById(R.id.btnViewDetails)
        
        fun bind(kindergartenClass: KindergartenClass) {
            tvClassName.text = kindergartenClass.className
            
            // Convert months to years for display
            val ageStartYears = kindergartenClass.ageRangeStart / 12
            val ageEndYears = kindergartenClass.ageRangeEnd / 12
            tvAgeRange.text = "Age Range: $ageStartYears-$ageEndYears years"
            
            // Display room number if available
            tvRoomNumber.text = "Room: ${kindergartenClass.roomNumber ?: "Not assigned"}"
            
            // Display child count from our map
            val childCount = childCountMap[kindergartenClass.classId] ?: 0
            val capacity = kindergartenClass.capacity
            tvKidsCount.text = "Students: $childCount / $capacity"
            
            btnViewDetails.setOnClickListener {
                listener.onClassClicked(kindergartenClass)
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_class, parent, false)
        return ClassViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val kindergartenClass = classes[position]
        holder.bind(kindergartenClass)
    }
    
    override fun getItemCount() = classes.size
    
    fun updateChildCount(classId: Long, count: Int) {
        childCountMap[classId] = count
        notifyDataSetChanged()
    }
    
    fun updateClasses(newClasses: List<KindergartenClass>) {
        classes = newClasses
        notifyDataSetChanged()
    }
}
