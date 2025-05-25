package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
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
import com.example.kindergardenmanager.data.repository.UserRepository
import com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Activity for managing student enrollments in classes
 */
class ManageEnrollmentsActivity : AppCompatActivity(), EnrollmentAdapter.EnrollmentListener {

    private lateinit var classRepository: ClassRepository
    private lateinit var childRepository: ChildRepository
    private lateinit var userRepository: UserRepository
    
    // UI Components
    private lateinit var toolbar: Toolbar
    private lateinit var spinnerClasses: Spinner
    private lateinit var recyclerViewEnrolledStudents: RecyclerView
    private lateinit var recyclerViewAvailableStudents: RecyclerView
    private lateinit var tvNoEnrolledStudents: TextView
    private lateinit var tvNoAvailableStudents: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var etSearchStudents: EditText
    
    // Data
    private var classList = mutableListOf<KindergartenClass>()
    private var selectedClassId: Long = 0
    private val parentMap = mutableMapOf<Long, User>()
    private lateinit var enrolledAdapter: EnrollmentAdapter
    private lateinit var availableAdapter: EnrollmentAdapter
    
    // Keep track of all available children for filtering
    private var allAvailableChildren = listOf<Child>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_enrollments)
        
        // Set up toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Manage Enrollments"
        
        // Initialize repositories
        classRepository = (application as KindergardenApplication).classRepository
        childRepository = (application as KindergardenApplication).childRepository
        userRepository = (application as KindergardenApplication).userRepository
        
        // Initialize UI components
        spinnerClasses = findViewById(R.id.spinnerClasses)
        recyclerViewEnrolledStudents = findViewById(R.id.recyclerViewEnrolledStudents)
        recyclerViewAvailableStudents = findViewById(R.id.recyclerViewAvailableStudents)
        tvNoEnrolledStudents = findViewById(R.id.tvNoEnrolledStudents)
        tvNoAvailableStudents = findViewById(R.id.tvNoAvailableStudents)
        progressBar = findViewById(R.id.progressBar)
        etSearchStudents = findViewById(R.id.etSearchStudents)
        
        // Set up adapters
        enrolledAdapter = EnrollmentAdapter(this, emptyList(), this, true)
        availableAdapter = EnrollmentAdapter(this, emptyList(), this, false)
        
        recyclerViewEnrolledStudents.adapter = enrolledAdapter
        recyclerViewAvailableStudents.adapter = availableAdapter
        
        // Setup search functionality
        setupSearch()
        
        // Show loading
        showLoading(true)
        
        // Load parent data (to show parent info for each child)
        loadParentData()
        
        // Load all classes for the spinner
        loadClasses()
        
        // Set up spinner selection listener
        spinnerClasses.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position > 0) { // Skip the "Select a class" item
                    selectedClassId = classList[position - 1].classId
                    loadEnrollmentData()
                } else {
                    // Clear the lists when "Select a class" is chosen
                    selectedClassId = 0
                    enrolledAdapter.updateChildren(emptyList())
                    availableAdapter.updateChildren(emptyList())
                    tvNoEnrolledStudents.visibility = View.VISIBLE
                    tvNoAvailableStudents.visibility = View.VISIBLE
                }
            }
            
            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedClassId = 0
            }
        }
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    
    private fun loadParentData() {
        try {
            userRepository.getUsersByRole(UserRole.PARENT).observe(this, Observer { parents ->
                if (parents != null) {
                    parents.forEach { parent ->
                        parentMap[parent.userId] = parent
                    }
                    
                    enrolledAdapter.updateParentInfo(parentMap)
                    availableAdapter.updateParentInfo(parentMap)
                }
            })
        } catch (e: Exception) {
            Toast.makeText(this, "Error loading parent data: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
    
    /**
     * Loads all classes from the database and populates spinner
     * 
     * This method includes error handling to prevent crashes when:
     * 1. The database is not properly initialized
     * 2. The classes table doesn't exist or has schema issues
     * 3. LiveData observer encounters errors
     * 
     * On error, it shows a user-friendly message and finishes the activity
     * to prevent further crashes down the line.
     */
    private fun loadClasses() {
        try {
            // Use LiveData observer to get classes
            classRepository.getAllClasses().observe(this, Observer { classes ->
                showLoading(false)
                
                if (classes != null && classes.isNotEmpty()) {
                    // Clear and update the class list
                    classList.clear()
                    classList.addAll(classes)
                    
                    // Set up class spinner with "Select a class" as the first option
                    val classNames = mutableListOf("Select a class")
                    classNames.addAll(classes.map { it.className })
                    
                    // Create and set the spinner adapter
                    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, classNames)
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerClasses.adapter = adapter
                } else {
                    // If no classes exist, inform the user and exit activity
                    Toast.makeText(this, "No classes available. Please create classes first.", Toast.LENGTH_LONG).show()
                    finish()
                }
            })
        } catch (e: Exception) {
            // Handle database exceptions gracefully
            showLoading(false)
            Toast.makeText(this, "Error loading classes: ${e.message}", Toast.LENGTH_SHORT).show()
            finish() // Exit the activity to prevent further errors
        }
    }
    
    private fun setupSearch() {
        etSearchStudents.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed
            }

            override fun afterTextChanged(s: Editable?) {
                filterAvailableStudents(s.toString())
            }
        })
    }

    private fun filterAvailableStudents(query: String) {
        if (query.isBlank()) {
            // If no query, show all available children
            availableAdapter.updateChildren(allAvailableChildren)
            tvNoAvailableStudents.visibility = if (allAvailableChildren.isEmpty()) View.VISIBLE else View.GONE
            return
        }

        // Filter children based on name or parent name
        val filteredList = allAvailableChildren.filter {
            // Check if child name or parent name contains the query (case insensitive)
            val childName = "${it.firstName} ${it.lastName}".lowercase()
            val parentName = parentMap[it.parentId]?.let { parent ->
                "${parent.firstName} ${parent.lastName}".lowercase()
            } ?: ""
            
            childName.contains(query.lowercase()) || parentName.contains(query.lowercase())
        }

        availableAdapter.updateChildren(filteredList)
        tvNoAvailableStudents.visibility = if (filteredList.isEmpty()) View.VISIBLE else View.GONE
    }

    private fun loadEnrollmentData() {
        if (selectedClassId <= 0) return
        
        showLoading(true)
        
        // Load enrolled students (children in the selected class)
        childRepository.getChildrenByClassId(selectedClassId).observe(this, Observer { enrolledChildren ->
            if (enrolledChildren != null) {
                enrolledAdapter.updateChildren(enrolledChildren)
                tvNoEnrolledStudents.visibility = if (enrolledChildren.isEmpty()) View.VISIBLE else View.GONE
            }
        })
        
        // Load available students (children not in any class or in other classes)
        childRepository.getAllChildren().observe(this, Observer { allChildren ->
            if (allChildren != null) {
                // Filter to get children who are either not enrolled or in other classes
                allAvailableChildren = allChildren.filter { it.classId == null || it.classId != selectedClassId }
                
                // Apply any current search filter
                val currentQuery = etSearchStudents.text.toString()
                if (currentQuery.isBlank()) {
                    availableAdapter.updateChildren(allAvailableChildren)
                } else {
                    filterAvailableStudents(currentQuery)
                }
                
                tvNoAvailableStudents.visibility = if (allAvailableChildren.isEmpty()) View.VISIBLE else View.GONE
                
                showLoading(false)
            }
        })
    }
    
    override fun onEnrollChild(child: Child) {
        if (selectedClassId <= 0) {
            Toast.makeText(this, "Please select a class first", Toast.LENGTH_SHORT).show()
            return
        }
        
        showLoading(true)
        
        // Check if class has capacity before enrolling
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Get class details to check capacity
                val classData = classRepository.getClassById(selectedClassId)
                if (classData == null) {
                    withContext(Dispatchers.Main) {
                        showLoading(false)
                        Toast.makeText(
                            this@ManageEnrollmentsActivity,
                            "Error: Class not found",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    return@launch
                }

                // Count current enrollments
                val currentEnrollments = childRepository.getChildrenCountByClassId(selectedClassId)
                if (currentEnrollments >= classData.capacity) {
                    withContext(Dispatchers.Main) {
                        showLoading(false)
                        Toast.makeText(
                            this@ManageEnrollmentsActivity,
                            "Error: Class ${classData.className} is at full capacity (${classData.capacity} students)",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    return@launch
                }
                
                // Update child's class assignment
                val updatedChild = child.copy(classId = selectedClassId)
                childRepository.updateChild(updatedChild)
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ManageEnrollmentsActivity,
                        "${child.firstName} ${child.lastName} enrolled successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ManageEnrollmentsActivity,
                        "Error enrolling student: ${e.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    
    override fun onUnenrollChild(child: Child) {
        showLoading(true)
        
        // Update child to remove class assignment
        val updatedChild = child.copy(classId = null)
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                childRepository.updateChild(updatedChild)
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ManageEnrollmentsActivity,
                        "${child.firstName} ${child.lastName} unenrolled successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ManageEnrollmentsActivity,
                        "Error unenrolling student: ${e.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
