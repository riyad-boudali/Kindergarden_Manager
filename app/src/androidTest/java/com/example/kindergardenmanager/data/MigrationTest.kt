package com.example.kindergardenmanager.data

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.kindergardenmanager.data.database.KindergardenDatabase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Test database migrations
 */
@RunWith(AndroidJUnit4::class)
class MigrationTest {
    private val TEST_DB = "migration-test"
    
    // Helper for testing migrations
    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        KindergardenDatabase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )
    
    @Test
    @Throws(IOException::class)
    fun migrate1To2() {
        // Create version 1 of the database
        val db = helper.createDatabase(TEST_DB, 1)
        
        // Insert test data for version 1
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS `users` (
                `userId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `username` TEXT NOT NULL,
                `email` TEXT NOT NULL,
                `password` TEXT NOT NULL,
                `role` TEXT NOT NULL,
                `firstName` TEXT NOT NULL,
                `lastName` TEXT NOT NULL
            )
        """)
        
        // Close version 1
        db.close()
        
        // Migrate to version 2
        val dbV2 = helper.runMigrationsAndValidate(TEST_DB, 2, true)
        
        // Verify version 2 schema
        dbV2.close()
    }
    
    @Test
    @Throws(IOException::class)
    fun migrate2To3() {
        // Create version 2 of the database
        val db = helper.createDatabase(TEST_DB, 2)
        
        // Insert test data for version 2
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS `users` (
                `userId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `username` TEXT NOT NULL,
                `email` TEXT NOT NULL,
                `password` TEXT NOT NULL,
                `role` TEXT NOT NULL,
                `firstName` TEXT NOT NULL,
                `lastName` TEXT NOT NULL
            )
        """)
        
        // Create 'children' table without classId column
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS `children` (
                `childId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `firstName` TEXT NOT NULL,
                `lastName` TEXT NOT NULL,
                `dateOfBirth` INTEGER NOT NULL,
                `parentId` INTEGER NOT NULL,
                `allergies` TEXT,
                `notes` TEXT
            )
        """)
        
        // Close version 2
        db.close()
        
        // Migrate to version 3
        val dbV3 = helper.runMigrationsAndValidate(TEST_DB, 3, true)
        
        // Verify version 3 schema - check if classes table exists and children has classId column
        val classesCursor = dbV3.query("SELECT name FROM sqlite_master WHERE type='table' AND name='classes'")
        assert(classesCursor.count > 0) { "Classes table should exist after migration to version 3" }
        classesCursor.close()
        
        // Check if classId column exists in children table
        val childrenColumnsCursor = dbV3.query("PRAGMA table_info(children)")
        var hasClassIdColumn = false
        while (childrenColumnsCursor.moveToNext()) {
            val columnName = childrenColumnsCursor.getString(childrenColumnsCursor.getColumnIndex("name"))
            if (columnName == "classId") {
                hasClassIdColumn = true
                break
            }
        }
        childrenColumnsCursor.close()
        
        assert(hasClassIdColumn) { "classId column should exist in children table after migration to version 3" }
        
        dbV3.close()
    }
}
