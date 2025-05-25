package com.example.kindergardenmanager.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kindergardenmanager.data.dao.AttendanceDao
import com.example.kindergardenmanager.data.dao.ChildDao
import com.example.kindergardenmanager.data.dao.ClassDao
import com.example.kindergardenmanager.data.dao.MessageDao
import com.example.kindergardenmanager.data.dao.UserDao
import com.example.kindergardenmanager.data.model.Attendance
import com.example.kindergardenmanager.data.model.Child
import com.example.kindergardenmanager.data.model.KindergartenClass
import com.example.kindergardenmanager.data.model.Message
import com.example.kindergardenmanager.data.model.User
import com.example.kindergardenmanager.data.model.UserRole
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        User::class, 
        KindergartenClass::class, 
        Child::class,
        Attendance::class,
        Message::class
    ], 
    version = 4, 
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class KindergardenDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun classDao(): ClassDao
    abstract fun childDao(): ChildDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: KindergardenDatabase? = null
        
        // Define migrations
        private val MIGRATION_1_2 = object : androidx.room.migration.Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migration from version 1 to 2
                // Just a placeholder if needed - assumes version 1 had basic structure
            }
        }
        
        private val MIGRATION_2_3 = object : androidx.room.migration.Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migration from version 2 to 3
                // Add any tables or columns added in version 3
                
                // Ensure classes table exists with proper structure
                database.execSQL("""
                    CREATE TABLE IF NOT EXISTS `classes` (
                        `classId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        `className` TEXT NOT NULL,
                        `ageRangeStart` INTEGER NOT NULL,
                        `ageRangeEnd` INTEGER NOT NULL,
                        `teacherId` INTEGER NOT NULL,
                        `capacity` INTEGER NOT NULL,
                        `roomNumber` TEXT,
                        `description` TEXT,
                        `isActive` INTEGER NOT NULL DEFAULT 1
                    )
                """)
                
                // Make sure children table has classId foreign key
                try {
                    // Check if classId column exists, if not add it
                    database.execSQL("ALTER TABLE `children` ADD COLUMN `classId` INTEGER")
                } catch (e: Exception) {
                    // Column might already exist, ignore
                }
            }
        }

        private val MIGRATION_3_4 = object : androidx.room.migration.Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migration from version 3 to 4
                // Add any tables or columns added in version 4
                
                // Create messages table
                database.execSQL("""
                    CREATE TABLE IF NOT EXISTS `messages` (
                        `messageId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        `senderId` INTEGER NOT NULL,
                        `recipientId` INTEGER NOT NULL,
                        `title` TEXT NOT NULL,
                        `content` TEXT NOT NULL,
                        `timestamp` INTEGER NOT NULL,
                        `isRead` INTEGER NOT NULL DEFAULT 0,
                        FOREIGN KEY(`senderId`) REFERENCES `users`(`userId`) ON DELETE CASCADE,
                        FOREIGN KEY(`recipientId`) REFERENCES `users`(`userId`) ON DELETE CASCADE
                    )
                """)

                // Create indices for foreign keys
                database.execSQL("CREATE INDEX IF NOT EXISTS `index_messages_senderId` ON `messages` (`senderId`)")
                database.execSQL("CREATE INDEX IF NOT EXISTS `index_messages_recipientId` ON `messages` (`recipientId`)")
            }
        }

        fun getDatabase(context: Context, scope: CoroutineScope): KindergardenDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KindergardenDatabase::class.java,
                    "kindergarden_database"
                )
                .addCallback(KindergardenDatabaseCallback(scope))
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
                .fallbackToDestructiveMigration() // This is a safety measure to prevent crashes
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
                )
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
                .fallbackToDestructiveMigration() // This is a safety measure to prevent crashes
                .build()
                
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
