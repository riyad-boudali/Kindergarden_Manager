package com.example.kindergardenmanager.ui.activity

import android.content.Intent
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
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.data.repository.ChildRepository
import com.example.kindergardenmanager.ui.adapter.ClassListAdapter
import com.example.kindergardenmanager.util.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date

class ViewClassesActivity : AppCompatActivity(), ClassListAdapter.ClassClickListener {

    private lateinit var classRepository: ClassRepository
    private lateinit var childRepository: ChildRepository
    private lateinit var sessionManager: SessionManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvNoClasses: TextView
    private lateinit var adapter: ClassListAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_classes)
        
        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Classes"
        
        // Initialize repositories
        classRepository = (application as KindergardenApplication).classRepository
        childRepository = (application as KindergardenApplication).childRepository
        sessionManager = SessionManager(this)
        
        // Initialize views
        recyclerView = findViewById(R.id.recyclerViewClasses)
        progressBar = findViewById(R.id.progressBar)
        tvNoClasses = findViewById(R.id.tvNoClasses)
        
        // Show loading
        showLoading(true)
        
        // Get teacher ID from session
        val teacherId = sessionManager.getUserId()
        
        // Add sample classes if this is the first run (for testing purposes)
        addSampleClassesIfEmpty(teacherId)
        
        // Create adapter
        adapter = ClassListAdapter(this, emptyList(), this)
        recyclerView.adapter = adapter
        
        // Load classes assigned to this teacher
        loadTeacherClasses(teacherId)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    
    private fun loadTeacherClasses(teacherId: Long) {
        classRepository.getClassesByTeacherId(teacherId).observe(this, Observer { classes ->
            showLoading(false)
            
            if (classes != null && classes.isNotEmpty()) {
                adapter = ClassListAdapter(this, classes, this)
                recyclerView.adapter = adapter
                tvNoClasses.visibility = View.GONE
                
                // For each class, observe its child count
                classes.forEach { kClass ->
                    childRepository.getChildrenByClassId(kClass.classId).observe(this, Observer { children ->
                        adapter.updateChildCount(kClass.classId, children.size)
                    })
                }
            } else {
                tvNoClasses.visibility = View.VISIBLE
            }
        })
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
    
    override fun onClassClicked(kindergartenClass: KindergartenClass) {
        // Navigate to class details activity
        val intent = Intent(this, ClassDetailActivity::class.java)
        intent.putExtra("CLASS_ID", kindergartenClass.classId)
        startActivity(intent)
    }
    
    private fun addSampleClassesIfEmpty(teacherId: Long) {
        // This is just for testing - add some sample classes if the database is empty
        classRepository.getAllClasses().observe(this, Observer { classes ->
            if (classes.isNullOrEmpty()) {
                // Add sample classes in a background thread
                CoroutineScope(Dispatchers.IO).launch {
                    val sampleClasses = listOf(
                        KindergartenClass(
                            className = "Stars Class",
                            ageRangeStart = 36, // 3 years in months
                            ageRangeEnd = 48,   // 4 years in months
                            teacherId = teacherId,
                            capacity = 20,
                            roomNumber = "A101",
                            description = "Class for 3-4 year olds focusing on basic skills development."
                        ),
                        KindergartenClass(
                            className = "Moon Class",
                            ageRangeStart = 48, // 4 years in months
                            ageRangeEnd = 60,   // 5 years in months
                            teacherId = teacherId,
                            capacity = 18,
                            roomNumber = "A102",
                            description = "Class for 4-5 year olds focusing on pre-reading and math skills."
                        ),
                        KindergartenClass(
                            className = "Sun Class",
                            ageRangeStart = 60, // 5 years in months
                            ageRangeEnd = 72,   // 6 years in months
                            teacherId = teacherId,
                            capacity = 15,
                            roomNumber = "B101",
                            description = "Class for 5-6 year olds preparing for elementary school."
                        )
                    )
                    
                    sampleClasses.forEach { kClass ->
                        try {
                            classRepository.addClass(kClass)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    
                    // Add sample children to these classes
                    addSampleChildren(teacherId)
                }
            }
        })
    }
    
    private fun addSampleChildren(teacherId: Long) {
        // Add some sample children to the classes
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Get the classes we just created
                val classes = classRepository.getClassesByTeacherId(teacherId).value
                
                if (!classes.isNullOrEmpty()) {
                    // Get a parent user (any parent will do for demo purposes)
                    val parentUsers = (application as KindergardenApplication).userRepository.getUsersByRole(
                        com.example.kindergardenmanager.data.model.UserRole.PARENT
                    ).value
                    
                    val parentId = if (!parentUsers.isNullOrEmpty()) {
                        parentUsers[0].userId
                    } else {
                        // Create a sample parent if none exists
                        val newParentId = (application as KindergardenApplication).userRepository.registerUser(
                            com.example.kindergardenmanager.data.model.User(
                                username = "parent1",
                                firstName = "Parent",
                                lastName = "User",
                                email = "parent@example.com",
                                password = "password123",
                                role = com.example.kindergardenmanager.data.model.UserRole.PARENT,
                                phoneNumber = "555-1234"
                            )
                        )
                        newParentId
                    }
                    
                    // Create sample children for each class
                    classes.forEach { kClass ->
                        // Create 5-10 children per class
                        val numChildren = (5..10).random()
                        for (i in 1..numChildren) {
                            val calendar = Calendar.getInstance()
                            
                            // Set birth date based on class age range
                            calendar.time = Date()
                            val randomMonthsInRange = (kClass.ageRangeStart..kClass.ageRangeEnd).random()
                            calendar.add(Calendar.MONTH, -randomMonthsInRange)
                            
                            val child = com.example.kindergardenmanager.data.model.Child(
                                firstName = "Child${i}",
                                lastName = "Student",
                                birthDate = calendar.time,
                                parentId = parentId,
                                classId = kClass.classId,
                                gender = if (i % 2 == 0) "Male" else "Female",
                                allergies = if (i % 3 == 0) "Peanuts" else null
                            )
                            
                            childRepository.addChild(child)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
