package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Child
import com.example.kindergardenmanager.data.model.User
import java.util.Calendar
import java.util.Date
import kotlin.math.floor

class ChildListAdapter(
    private val context: Context,
    private var children: List<Child>,
    private val parentMap: Map<Long, User> // Added parentMap to provide parent details
) : RecyclerView.Adapter<ChildListAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvChildName: TextView = view.findViewById(R.id.tvChildName)
        val tvChildAge: TextView = view.findViewById(R.id.tvChildAge)
        val tvAllergies: TextView = view.findViewById(R.id.tvAllergies)
        val tvParentName: TextView = view.findViewById(R.id.tvParentName)

        fun bind(child: Child) {
            tvChildName.text = "${child.firstName} ${child.lastName}"

            // Calculate age
            val age = calculateAge(child.birthDate)
            tvChildAge.text = "Age: $age years"

            // Display allergies
            tvAllergies.text = child.allergies ?: "None"

            // Display parent's name if available, otherwise fallback to parent ID
            val parent = parentMap[child.parentId]
            tvParentName.text = parent?.let { "Parent: ${it.firstName} ${it.lastName}" } ?: "Parent ID: ${child.parentId}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_child, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val child = children[position]
        holder.bind(child)
    }

    override fun getItemCount() = children.size

    fun updateChildren(newChildren: List<Child>) {
        children = newChildren
        notifyDataSetChanged()
    }

    private fun calculateAge(birthDate: Date): Int {
        val calendar = Calendar.getInstance()
        val today = calendar.timeInMillis

        calendar.time = birthDate
        val birthTime = calendar.timeInMillis

        val difference = today - birthTime
        val years = difference / (1000L * 60 * 60 * 24 * 365.25)

        return floor(years).toInt()
    }
}
