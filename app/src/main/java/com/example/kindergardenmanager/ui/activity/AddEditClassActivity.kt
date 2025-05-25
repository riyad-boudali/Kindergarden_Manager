package com.example.kindergardenmanager.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.data.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddEditClassActivity : AppCompatActivity() {

    private lateinit var classRepository: ClassRepository
    private lateinit var userRepository: UserRepository
    
    // UI components
    private lateinit var toolbar: Toolbar
    private lateinit var etClassName: TextInputEditText
    private lateinit var etAgeStart: TextInputEditText
    private lateinit var etAgeEnd: TextInputEditText
    private lateinit var etCapacity: TextInputEditText
    private lateinit var etRoomNumber: TextInputEditText
    private lateinit var etDescription: TextInputEditText
    private lateinit var spinnerTeachers: Spinner
    private lateinit var btnSaveClass: Button
    private lateinit var progressBar: ProgressBar
    
    // Form validation layouts
    private lateinit var layoutClassName: TextInputLayout
    private lateinit var layoutAgeStart: TextInputLayout
    private lateinit var layoutAgeEnd: TextInputLayout
    private lateinit var layoutCapacity: TextInputLayout
    
    // Data
    private var classId: Long = 0
    private var teacherList = mutableListOf<User>()
    private var editMode = false
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_class)
        
        // Get class ID if we're editing an existing class
        classId = intent.getLongExtra("CLASS_ID", 0)
        editMode = classId > 0
        
        // Initialize repositories
        classRepository = (application as KindergardenApplication).classRepository
        userRepository = (application as KindergardenApplication).userRepository
        
        // Initialize UI components
        initUI()
        
        // Set up toolbar based on mode (add or edit)
        setupToolbar()
        
        // Load teacher data for spinner
        loadTeachers()
        
        // If editing, load class data
        if (editMode) {
            loadClassDetails()
        }
    }
    
    private fun initUI() {
        toolbar = findViewById(R.id.toolbar)
        etClassName = findViewById(R.id.etClassName)
        etAgeStart = findViewById(R.id.etAgeStart)
        etAgeEnd = findViewById(R.id.etAgeEnd)
        etCapacity = findViewById(R.id.etCapacity)
        etRoomNumber = findViewById(R.id.etRoomNumber)
        etDescription = findViewById(R.id.etDescription)
        spinnerTeachers = findViewById(R.id.spinnerTeachers)
        btnSaveClass = findViewById(R.id.btnSaveClass)
        progressBar = findViewById(R.id.progressBar)
        
        // Form validation layouts
        layoutClassName = findViewById(R.id.layoutClassName)
        layoutAgeStart = findViewById(R.id.layoutAgeStart)
        layoutAgeEnd = findViewById(R.id.layoutAgeEnd)
        layoutCapacity = findViewById(R.id.layoutCapacity)
        
        // Set up save button
        btnSaveClass.setOnClickListener {
            if (validateForm()) {
                saveClass()
            }
        }
    }
    
    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = if (editMode) "Edit Class" else "Add Class"
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    
    private fun loadTeachers() {
        showLoading(true)
        
        userRepository.getUsersByRole(UserRole.TEACHER).observe(this, Observer { teachers ->
            showLoading(false)
            
            if (teachers != null && teachers.isNotEmpty()) {
                teacherList.clear()
                teacherList.add(User(
                    userId = -1, 
                    firstName = "Select", 
                    lastName = "Teacher", 
                    role = UserRole.TEACHER,
                    username = "placeholder",
                    email = "placeholder@example.com",
                    password = "placeholder"
                ))
                teacherList.addAll(teachers)
                
                val adapter = ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_item,
                    teacherList.map { "${it.firstName} ${it.lastName}" }
                )
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerTeachers.adapter = adapter
                
                // If we're editing an existing class, select the right teacher
                if (editMode) {
                    loadClassDetails()
                }
            } else {
                Toast.makeText(this, "No teachers available. Please add teachers first.", Toast.LENGTH_LONG).show()
                finish()
            }
        })
    }
    
    private fun loadClassDetails() {
        showLoading(true)
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val kindergartenClass = classRepository.getClassById(classId)
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    
                    if (kindergartenClass != null) {
                        populateFormWithClassDetails(kindergartenClass)
                    } else {
                        Toast.makeText(this@AddEditClassActivity, "Class not found", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@AddEditClassActivity,
                        "Error loading class: ${e.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
        }
    }
    
    private fun populateFormWithClassDetails(kindergartenClass: KindergartenClass) {
        etClassName.setText(kindergartenClass.className)
        etAgeStart.setText((kindergartenClass.ageRangeStart / 12).toString())
        etAgeEnd.setText((kindergartenClass.ageRangeEnd / 12).toString())
        etCapacity.setText(kindergartenClass.capacity.toString())
        etRoomNumber.setText(kindergartenClass.roomNumber)
        etDescription.setText(kindergartenClass.description)
        
        // Select the right teacher in spinner
        val teacherPosition = teacherList.indexOfFirst { it.userId == kindergartenClass.teacherId }
        if (teacherPosition != -1) {
            spinnerTeachers.setSelection(teacherPosition)
        }
    }
    
    private fun validateForm(): Boolean {
        var isValid = true
        
        // Validate class name
        if (etClassName.text.isNullOrBlank()) {
            layoutClassName.error = "Class name is required"
            isValid = false
        } else {
            layoutClassName.error = null
        }
        
        // Validate age range start
        if (etAgeStart.text.isNullOrBlank()) {
            layoutAgeStart.error = "Start age is required"
            isValid = false
        } else {
            layoutAgeStart.error = null
        }
        
        // Validate age range end
        if (etAgeEnd.text.isNullOrBlank()) {
            layoutAgeEnd.error = "End age is required"
            isValid = false
        } else if (!etAgeStart.text.isNullOrBlank() && !etAgeEnd.text.isNullOrBlank() &&
            etAgeStart.text.toString().toInt() >= etAgeEnd.text.toString().toInt()) {
            layoutAgeEnd.error = "End age must be greater than start age"
            isValid = false
        } else {
            layoutAgeEnd.error = null
        }
        
        // Validate capacity
        if (etCapacity.text.isNullOrBlank()) {
            layoutCapacity.error = "Capacity is required"
            isValid = false
        } else if (etCapacity.text.toString().toIntOrNull() ?: 0 <= 0) {
            layoutCapacity.error = "Capacity must be greater than zero"
            isValid = false
        } else {
            layoutCapacity.error = null
        }
        
        // Validate teacher selection
        if (spinnerTeachers.selectedItemPosition <= 0) {
            Toast.makeText(this, "Please select a teacher", Toast.LENGTH_SHORT).show()
            isValid = false
        }
        
        return isValid
    }
    
    private fun saveClass() {
        showLoading(true)
        
        // Get values from form
        val className = etClassName.text.toString()
        val ageRangeStart = etAgeStart.text.toString().toInt() * 12 // Convert to months
        val ageRangeEnd = etAgeEnd.text.toString().toInt() * 12 // Convert to months
        val capacity = etCapacity.text.toString().toInt()
        val roomNumber = etRoomNumber.text.toString().takeIf { it.isNotBlank() }
        val description = etDescription.text.toString().takeIf { it.isNotBlank() }
        
        // Get selected teacher
        val selectedTeacherPosition = spinnerTeachers.selectedItemPosition
        val teacherId = if (selectedTeacherPosition > 0) {
            teacherList[selectedTeacherPosition].userId
        } else {
            // This shouldn't happen due to validation
            Toast.makeText(this, "Please select a teacher", Toast.LENGTH_SHORT).show()
            showLoading(false)
            return
        }
        
        // Create or update the class
        val kindergartenClass = KindergartenClass(
            classId = if (editMode) classId else 0,
            className = className,
            ageRangeStart = ageRangeStart,
            ageRangeEnd = ageRangeEnd,
            teacherId = teacherId,
            capacity = capacity,
            roomNumber = roomNumber,
            description = description
        )
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (editMode) {
                    classRepository.updateClass(kindergartenClass)
                } else {
                    classRepository.addClass(kindergartenClass)
                }
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@AddEditClassActivity,
                        "Class ${if (editMode) "updated" else "added"} successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@AddEditClassActivity,
                        "Error saving class: ${e.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        btnSaveClass.isEnabled = !isLoading
    }
}
