package com.example.kindergardenmanager.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kindergardenmanager.data.dao.UserDao
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [User::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class KindergardenDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: KindergardenDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): KindergardenDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KindergardenDatabase::class.java,
                    "kindergarden_database"
                )
                .addCallback(KindergardenDatabaseCallback(scope))
                .build()
                
                INSTANCE = instance
                instance
            }
        }
        
        // Convenience method for when no scope is available
        fun getDatabase(context: Context): KindergardenDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KindergardenDatabase::class.java,
                    "kindergarden_database"
                ).build()
                
                INSTANCE = instance
                instance
            }
        }
        
        private class KindergardenDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        // Prepopulate with an admin account
                        val userDao = database.userDao()
                        
                        // Add default admin
                        val admin = User(
                            username = "admin",
                            email = "admin@kindergarden.com",
                            password = "admin123", // In production, this should be hashed
                            role = UserRole.ADMIN,
                            firstName = "System",
                            lastName = "Administrator"
                        )
                        userDao.insertUser(admin)
                    }
                }
            }
        }
    }
}
