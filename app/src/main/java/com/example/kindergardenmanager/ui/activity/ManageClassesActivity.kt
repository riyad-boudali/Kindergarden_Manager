package com.example.kindergardenmanager.ui.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.kindergardenmanager.KindergardenApplication
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.ChildRepository
import com.example.kindergardenmanager.data.repository.ClassRepository
import com.example.kindergardenmanager.data.repository.UserRepository
import com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Activity for admins to manage kindergarten classes
 */
class ManageClassesActivity : AppCompatActivity(), ClassAdminAdapter.ClassAdminClickListener {

    private lateinit var classRepository: ClassRepository
    private lateinit var userRepository: UserRepository
    private lateinit var childRepository: ChildRepository
    private lateinit var adapter: ClassAdminAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvNoClasses: TextView
    
    // Cache for teacher data
    private val teacherMap = mutableMapOf<Long, User>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_classes)
        
        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Manage Classes"
        
        try {
            // Initialize repositories
            classRepository = (application as KindergardenApplication).classRepository
            userRepository = (application as KindergardenApplication).userRepository
            childRepository = (application as KindergardenApplication).childRepository
            
            // Initialize views
            recyclerView = findViewById(R.id.recyclerViewClasses)
            progressBar = findViewById(R.id.progressBar)
            tvNoClasses = findViewById(R.id.tvNoClasses)
            
            // Create adapter
            adapter = ClassAdminAdapter(this, emptyList(), this)
            recyclerView.adapter = adapter
            
            // Show loading
            showLoading(true)
            
            // Load teacher data to cache
            loadTeacherData()
            
            // Load all classes
            loadClasses()
        } catch (e: Exception) {
            // Handle initialization errors
            Toast.makeText(this, "Error initializing: ${e.message}", Toast.LENGTH_LONG).show()
            // Log the error
            android.util.Log.e("ManageClassesActivity", "Initialization error", e)
            finish()
        }
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    
    private fun loadTeacherData() {
        userRepository.getUsersByRole(UserRole.TEACHER).observe(this, Observer { teachers ->
            if (teachers != null) {
                teachers.forEach { teacher ->
                    teacherMap[teacher.userId] = teacher
                }
                adapter.updateTeacherInfo(teacherMap)
            }
        })
    }
    
    private fun loadClasses() {
        try {
            classRepository.getAllClasses().observe(this, Observer { classes ->
                showLoading(false)
                
                if (classes != null && classes.isNotEmpty()) {
                    adapter.updateClasses(classes)
                    tvNoClasses.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    
                    // Load student counts for each class
                    classes.forEach { kClass ->
                        try {
                            childRepository.getChildrenByClassId(kClass.classId).observe(this, Observer { children ->
                                adapter.updateStudentCount(kClass.classId, children?.size ?: 0)
                            })
                        } catch (e: Exception) {
                            // Handle exception for individual class gracefully
                            adapter.updateStudentCount(kClass.classId, 0)
                        }
                    }
                } else {
                    adapter.updateClasses(emptyList())
                    tvNoClasses.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
            })
        } catch (e: Exception) {
            // Handle any database or Room exceptions
            showLoading(false)
            Toast.makeText(this, "Error loading classes: ${e.message}", Toast.LENGTH_SHORT).show()
            tvNoClasses.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        }
    }
    
    private fun showLoading(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
    
    override fun onClassClicked(kindergartenClass: KindergartenClass) {
        // Navigate to class details page
        val intent = Intent(this, ClassDetailAdminActivity::class.java)
        intent.putExtra("CLASS_ID", kindergartenClass.classId)
        startActivity(intent)
    }
    
    override fun onEditClass(kindergartenClass: KindergartenClass) {
        Toast.makeText(this, "Editing classes is currently disabled.", Toast.LENGTH_SHORT).show()
    }
    
    override fun onDeleteClass(kindergartenClass: KindergartenClass) {
        // Show confirmation dialog
        AlertDialog.Builder(this)
            .setTitle("Delete Class")
            .setMessage("Are you sure you want to delete ${kindergartenClass.className}? This will remove all student enrollments for this class.")
            .setPositiveButton("Delete") { _, _ ->
                deleteClass(kindergartenClass)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
    
    private fun deleteClass(kindergartenClass: KindergartenClass) {
        showLoading(true)
        
        CoroutineScope(Dispatchers.IO).launch {
            try {
                classRepository.deleteClass(kindergartenClass)
                
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ManageClassesActivity,
                        "Class deleted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showLoading(false)
                    Toast.makeText(
                        this@ManageClassesActivity,
                        "Failed to delete class: ${e.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
