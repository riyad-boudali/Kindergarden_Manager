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

/**
 * Activity for teachers to select which class to take attendance for
 */
class ViewClassesForAttendanceActivity : AppCompatActivity(), ClassListAdapter.ClassClickListener {

    private lateinit var classRepository: ClassRepository
    private lateinit var childRepository: ChildRepository
    private lateinit var sessionManager: SessionManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvNoClasses: TextView
    private lateinit var adapter: ClassListAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_classes_for_attendance)
        
        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Select Class for Attendance"
        
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
        // Navigate to take attendance activity for selected class
        val intent = Intent(this, TakeAttendanceActivity::class.java)
        intent.putExtra("CLASS_ID", kindergartenClass.classId)
        startActivity(intent)
    }
}
