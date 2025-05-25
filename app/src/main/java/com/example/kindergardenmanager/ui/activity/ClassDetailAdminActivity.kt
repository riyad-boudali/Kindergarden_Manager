package com.example.kindergardenmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Child
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.ChildRepository
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.data.repository.UserRepository
import com.example.kindergardenmanager.ui.adapter.ChildListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Activity for administrators to view class details and enrolled students
 * Simplified implementation to fix crashes
 */
class ClassDetailAdminActivity : AppCompatActivity() {
    
    private lateinit var classRepository: ClassRepository
    private lateinit var userRepository: UserRepository
    private lateinit var childRepository: ChildRepository
    
    private lateinit var tvClassName: TextView
    private lateinit var tvAgeRange: TextView
    private lateinit var tvTeacherName: TextView
    private lateinit var tvCapacity: TextView
    private lateinit var tvRoom: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvStatus: TextView
    private lateinit var cardDetails: CardView
    private lateinit var recyclerViewStudents: RecyclerView
    private lateinit var tvNoStudents: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnEditClass: Button
    private lateinit var btnManageEnrollments: Button
    
    private var classId: Long = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_detail_admin)
        
        try {
            // Set up toolbar with back button
            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Class Details"
            
            // Get repositories from application
            classRepository = (application as KindergardenApplication).classRepository
            userRepository = (application as KindergardenApplication).userRepository
            childRepository = (application as KindergardenApplication).childRepository
            
            // Initialize views
            initializeViews()
            
            // Get class ID from intent
            classId = intent.getLongExtra("CLASS_ID", 0)
            if (classId <= 0) {
                Toast.makeText(this, "Invalid class ID", Toast.LENGTH_SHORT).show()
                finish()
                return
            }
            
            // Set up simple recycler view
            recyclerViewStudents.layoutManager = LinearLayoutManager(this)
            
            // Set up buttons
            setupButtons()
            
            // Load basic class info
            loadBasicClassInfo()
        } catch (e: Exception) {
            Toast.makeText(this, "Error initializing: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }
    
    private fun initializeViews() {
        try {
            tvClassName = findViewById(R.id.tvClassName)
            tvAgeRange = findViewById(R.id.tvAgeRange)
            tvTeacherName = findViewById(R.id.tvTeacherName)
            tvCapacity = findViewById(R.id.tvCapacity)
            tvRoom = findViewById(R.id.tvRoom)
            tvDescription = findViewById(R.id.tvDescription)
            tvStatus = findViewById(R.id.tvStatus)
            cardDetails = findViewById(R.id.cardDetails)
            recyclerViewStudents = findViewById(R.id.recyclerViewStudents)
            tvNoStudents = findViewById(R.id.tvNoStudents)
            progressBar = findViewById(R.id.progressBar)
            btnEditClass = findViewById(R.id.btnEditClass)
            btnManageEnrollments = findViewById(R.id.btnManageEnrollments)
        } catch (e: Exception) {
            Toast.makeText(this, "Error finding views: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
    
    private fun setupButtons() {
        btnEditClass.setOnClickListener {
            try {
                val intent = Intent(this, AddEditClassActivity::class.java)
                intent.putExtra("CLASS_ID", classId)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Error navigating to Edit Class: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
        
        btnManageEnrollments.setOnClickListener {
            try {
                val intent = Intent(this, ManageEnrollmentsActivity::class.java)
                intent.putExtra("CLASS_ID", classId)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Error navigating to Manage Enrollments: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun loadBasicClassInfo() {
        showLoading(true)
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val classData = classRepository.getClassById(classId)
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    if (classData != null) {
                        // Display basic info
                        tvClassName.text = classData.className
                        val ageStartYears = classData.ageRangeStart / 12
                        val ageEndYears = classData.ageRangeEnd / 12
                        tvAgeRange.text = "$ageStartYears-$ageEndYears years"
                        tvCapacity.text = "${classData.capacity} students"
                        tvRoom.text = classData.roomNumber ?: "Not assigned"
                        tvDescription.text = classData.description ?: "No description"
                        tvStatus.text = if (classData.isActive) "Active" else "Inactive"
                        cardDetails.visibility = View.VISIBLE
                        
                        // Load teacher data
                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                val teacher = userRepository.getUserById(classData.teacherId)
                                withContext(Dispatchers.Main) {
                                    if (teacher != null) {
                                        tvTeacherName.text = "${teacher.firstName} ${teacher.lastName}"
                                    } else {
                                        tvTeacherName.text = "Unknown Teacher"
                                    }
                                }
                            } catch (e: Exception) {
                                withContext(Dispatchers.Main) {
                                    tvTeacherName.text = "Unknown Teacher"
                                }
                            }
                        }
                        
                        // Load students
                        loadStudentList(classData.classId)
                    } else {
                        Toast.makeText(this@ClassDetailAdminActivity, "Class not found", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ClassDetailAdminActivity,
                        "Error loading class: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    
    private fun loadStudentList(classId: Long) {
        childRepository.getChildrenByClassId(classId).observe(this, Observer { children ->
            if (children != null && children.isNotEmpty()) {
                tvNoStudents.visibility = View.GONE
                val parentMap = mutableMapOf<Long, User>()

                // Load parent data
                userRepository.getUsersByRole(UserRole.PARENT).observe(this, Observer { parents ->
                    if (parents != null) {
                        parents.forEach { parent ->
                            parentMap[parent.userId] = parent
                        }

                        // Set up adapter with parentMap
                        val adapter = ChildListAdapter(this, children, parentMap)
                        recyclerViewStudents.adapter = adapter
                    }
                })
            } else {
                tvNoStudents.visibility = View.VISIBLE
            }
        })
    }
    
    private fun showLoading(isLoading: Boolean) {
        try {
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        } catch (e: Exception) {
            // Ignore if view not found
        }
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
