package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Child
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.ChildRepository
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.ui.adapter.ChildListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClassDetailActivity : AppCompatActivity() {

    private lateinit var classRepository: ClassRepository
    private lateinit var childRepository: ChildRepository
    private lateinit var progressBar: ProgressBar
    private lateinit var tvClassName: TextView
    private lateinit var tvAgeRange: TextView
    private lateinit var tvRoomNumber: TextView
    private lateinit var tvCapacity: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvNoStudents: TextView
    private lateinit var recyclerViewStudents: RecyclerView
    private lateinit var adapter: ChildListAdapter

    private val parentMap = mutableMapOf<Long, User>() // Added to store parent data

    private var classId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_detail)

        // Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Class Details"

        // Get class ID from intent
        classId = intent.getLongExtra("CLASS_ID", 0)
        if (classId == 0L) {
            finish()
            return
        }

        // Initialize repositories
        classRepository = (application as KindergardenApplication).classRepository
        childRepository = (application as KindergardenApplication).childRepository

        // Initialize views
        progressBar = findViewById(R.id.progressBar)
        tvClassName = findViewById(R.id.tvClassName)
        tvAgeRange = findViewById(R.id.tvAgeRange)
        tvRoomNumber = findViewById(R.id.tvRoomNumber)
        tvCapacity = findViewById(R.id.tvCapacity)
        tvDescription = findViewById(R.id.tvDescription)
        tvNoStudents = findViewById(R.id.tvNoStudents)
        recyclerViewStudents = findViewById(R.id.recyclerViewStudents)

        // Load parent data
        loadParentData()

        // Set up adapter with parentMap
        adapter = ChildListAdapter(this, emptyList(), parentMap)
        recyclerViewStudents.adapter = adapter

        // Load class details
        loadClassDetails()

        // Load students in this class
        loadClassStudents()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadClassDetails() {
        showLoading(true)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val kindergartenClass = classRepository.getClassById(classId)

                withContext(Dispatchers.Main) {
                    showLoading(false)

                    if (kindergartenClass != null) {
                        displayClassDetails(kindergartenClass)
                    } else {
                        finish()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    finish()
                }
            }
        }
    }

    private fun displayClassDetails(kindergartenClass: KindergartenClass) {
        supportActionBar?.title = kindergartenClass.className

        tvClassName.text = kindergartenClass.className

        // Convert months to years for display
        val ageStartYears = kindergartenClass.ageRangeStart / 12
        val ageEndYears = kindergartenClass.ageRangeEnd / 12
        tvAgeRange.text = "Age Range: $ageStartYears-$ageEndYears years"

        tvRoomNumber.text = "Room: ${kindergartenClass.roomNumber ?: "Not assigned"}"
        tvCapacity.text = "Capacity: ${kindergartenClass.capacity} students"

        if (!kindergartenClass.description.isNullOrEmpty()) {
            tvDescription.text = kindergartenClass.description
            tvDescription.visibility = View.VISIBLE
        } else {
            tvDescription.visibility = View.GONE
        }
    }

    private fun loadClassStudents() {
        childRepository.getChildrenByClassId(classId).observe(this, Observer { children ->
            if (children != null && children.isNotEmpty()) {
                tvNoStudents.visibility = View.GONE
                adapter.updateChildren(children)
            } else {
                tvNoStudents.visibility = View.VISIBLE
            }
        })
    }

    private fun loadParentData() {
        (application as KindergardenApplication).userRepository.getUsersByRole(UserRole.PARENT).observe(this, Observer { parents ->
            if (parents != null) {
                parents.forEach { parent ->
                    parentMap[parent.userId] = parent
                }
                adapter.notifyDataSetChanged() // Update adapter with new parent data
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
