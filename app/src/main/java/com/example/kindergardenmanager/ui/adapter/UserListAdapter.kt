package com.example.kindergardenmanager.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kindergardenmanager.R
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import com.example.kindergardenmanager.data.repository.UserRepository
import com.example.kindergardenmanager.ui.activity.EditUserActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface UserActionListener {
    fun onUserDeleted(user: User)
    fun onUserEdit(user: User)
}

class UserListAdapter(
    private val context: Context, 
    private val users: List<User>,
    private val userRepository: UserRepository,
    private val listener: UserActionListener
) : BaseAdapter() {

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): Any {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return users[position].userId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        val user = users[position]
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvRole = view.findViewById<TextView>(R.id.tvRole)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val btnEditUser = view.findViewById<Button>(R.id.btnEditUser)
        val btnDeleteUser = view.findViewById<Button>(R.id.btnDeleteUser)

        tvName.text = "${user.firstName} ${user.lastName}"
        tvRole.text = "Role: ${user.role.name}"
        tvEmail.text = "Email: ${user.email}"

        // Don't allow editing or deleting admin users
        if (user.role == UserRole.ADMIN) {
            btnEditUser.isEnabled = false
            btnDeleteUser.isEnabled = false
            btnEditUser.alpha = 0.5f
            btnDeleteUser.alpha = 0.5f
        } else {
            btnEditUser.isEnabled = true
            btnDeleteUser.isEnabled = true
            btnEditUser.alpha = 1.0f
            btnDeleteUser.alpha = 1.0f
        }

        // Edit button click listener
        btnEditUser.setOnClickListener {
            listener.onUserEdit(user)
        }

        // Delete button click listener
        btnDeleteUser.setOnClickListener {
            confirmDeleteUser(user)
        }

        return view
    }

    private fun confirmDeleteUser(user: User) {
        AlertDialog.Builder(context)
            .setTitle("Delete User")
            .setMessage("Are you sure you want to delete ${user.firstName} ${user.lastName}?")
            .setPositiveButton("Delete") { _, _ ->
                // Delete user in background thread
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        userRepository.deleteUser(user)
                        
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "User deleted successfully", Toast.LENGTH_SHORT).show()
                            listener.onUserDeleted(user)
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Error deleting user: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
