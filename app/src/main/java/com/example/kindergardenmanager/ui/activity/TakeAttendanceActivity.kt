package com.example.kindergardenmanager.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.Attendance
import com.example.kindergardenmanager.data.model.Child
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.repository.AttendanceRepository
import com.example.kindergardenmanager.data.repository.ChildRepository
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.ui.adapter.AttendanceAdapter
import com.example.kindergardenmanager.util.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class TakeAttendanceActivity : AppCompatActivity(), AttendanceAdapter.AttendanceListener {

    private lateinit var classRepository: ClassRepository
    private lateinit var childRepository: ChildRepository
    private lateinit var attendanceRepository: AttendanceRepository
    private lateinit var sessionManager: SessionManager
    
    // UI Components
    private lateinit var toolbar: Toolbar
    private lateinit var tvClassName: TextView
    private lateinit var tvSelectedDate: TextView
    private lateinit var btnChangeDate: Button
    private lateinit var recyclerViewAttendance: RecyclerView
    private lateinit var tvNoStudents: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnMarkAll: Button
    private lateinit var btnUnmarkAll: Button
    private lateinit var btnSaveAttendance: Button
    
    // Data
    private lateinit var adapter: AttendanceAdapter
    private var classId: Long = 0
    private lateinit var selectedDate: Date
    private lateinit var dateFormat: SimpleDateFormat
    private var kindergartenClass: KindergartenClass? = null
    private var children: List<Child> = emptyList()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_attendance)
        
        // Get class ID from intent
        classId = intent.getLongExtra("CLASS_ID", 0)
        if (classId == 0L) {
            Toast.makeText(this, "Class not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        
        // Initialize date format
        dateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
        
        // Initialize selected date to today
        selectedDate = Calendar.getInstance().time
        
        // Initialize repositories
        classRepository = (application as KindergardenApplication).classRepository
        childRepository = (application as KindergardenApplication).childRepository
        attendanceRepository = (application as KindergardenApplication).attendanceRepository
        sessionManager = SessionManager(this)
        
        // Initialize UI components
        initUI()
        
        // Set up toolbar
        setupToolbar()
        
        // Load class details
        loadClassDetails()
        
        // Load students
        loadStudents()
        
        // Check if there's existing attendance for today
        checkExistingAttendance()
    }
    
    private fun initUI() {
        toolbar = findViewById(R.id.toolbar)
        tvClassName = findViewById(R.id.tvClassName)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        btnChangeDate = findViewById(R.id.btnChangeDate)
        recyclerViewAttendance = findViewById(R.id.recyclerViewAttendance)
        tvNoStudents = findViewById(R.id.tvNoStudents)
        progressBar = findViewById(R.id.progressBar)
        btnMarkAll = findViewById(R.id.btnMarkAll)
        btnUnmarkAll = findViewById(R.id.btnUnmarkAll)
        btnSaveAttendance = findViewById(R.id.btnSaveAttendance)
        
        // Set current date
        tvSelectedDate.text = dateFormat.format(selectedDate)
        
        // Set up date change button
        btnChangeDate.setOnClickListener {
            showDatePickerDialog()
        }
        
        // Set up mark all button
        btnMarkAll.setOnClickListener {
            setAllAttendance(true)
        }
        
        // Set up unmark all button
        btnUnmarkAll.setOnClickListener {
            setAllAttendance(false)
        }
        
        // Set up save button
        btnSaveAttendance.setOnClickListener {
            saveAttendance()
        }
        
        // Set up adapter
        adapter = AttendanceAdapter(this, emptyList(), this)
        recyclerViewAttendance.adapter = adapter
    }
    
    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Take Attendance"
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
                kindergartenClass = classRepository.getClassById(classId)
                
                withContext(Dispatchers.Main) {
                    if (kindergartenClass != null) {
                        tvClassName.text = kindergartenClass?.className
                        supportActionBar?.title = "Attendance: ${kindergartenClass?.className}"
                    } else {
                        Toast.makeText(this@TakeAttendanceActivity, "Class not found", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@TakeAttendanceActivity, "Failed to load class details", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
    
    private fun loadStudents() {
        childRepository.getChildrenByClassId(classId).observe(this, Observer { students ->
            showLoading(false)
            
            if (students != null && students.isNotEmpty()) {
                children = students
                adapter.updateChildren(students)
                tvNoStudents.visibility = View.GONE
                recyclerViewAttendance.visibility = View.VISIBLE
            } else {
                tvNoStudents.visibility = View.VISIBLE
                recyclerViewAttendance.visibility = View.GONE
            }
        })
    }
    
    private fun checkExistingAttendance() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val existingAttendance = attendanceRepository.getAttendanceByClassAndDate(classId, selectedDate).value
                
                withContext(Dispatchers.Main) {
                    if (existingAttendance != null && existingAttendance.isNotEmpty()) {
                        // Map attendance to child IDs
                        val attendanceMap = existingAttendance.associate {
                            it.childId to it.isPresent
                        }
                        
                        // Update the adapter with existing attendance
                        adapter.updateAllAttendanceStatuses(attendanceMap)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        calendar.time = selectedDate
        
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                calendar.set(Calendar.YEAR, selectedYear)
                calendar.set(Calendar.MONTH, selectedMonth)
                calendar.set(Calendar.DAY_OF_MONTH, selectedDay)
                
                selectedDate = calendar.time
                tvSelectedDate.text = dateFormat.format(selectedDate)
                
                // Check if there's existing attendance for this date
                checkExistingAttendance()
            },
            year,
            month,
            dayOfMonth
        )
        
        datePickerDialog.show()
    }
    
    private fun setAllAttendance(isPresent: Boolean) {
        for (child in children) {
            adapter.setAttendanceStatus(child.childId, isPresent)
        }
    }
    
    private fun saveAttendance() {
        showLoading(true)
        
        // Get attendance status for all children
        val attendanceStatuses = adapter.getAllAttendanceStatuses()
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // First delete any existing attendance records for this class and date
                attendanceRepository.deleteAttendanceForClassAndDate(classId, selectedDate)
                
                // Then save new attendance records
                for ((childId, isPresent) in attendanceStatuses) {
                    val attendance = Attendance(
                        childId = childId,
                        classId = classId,
                        date = selectedDate,
                        isPresent = isPresent
                    )
                    attendanceRepository.addAttendance(attendance)
                }
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(this@TakeAttendanceActivity, "Attendance saved successfully", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@TakeAttendanceActivity,
                        "Error saving attendance: ${e.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                e.printStackTrace()
            }
        }
    }
    
    override fun onAttendanceChanged(childId: Long, isPresent: Boolean) {
        // This is called when attendance status changes via checkbox
        // Nothing to do here as the adapter already updates its internal state
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}
