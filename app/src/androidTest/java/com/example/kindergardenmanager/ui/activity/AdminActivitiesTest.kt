package com.example.kindergardenmanager.ui.activity

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.kindergardenmanager.R
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for admin activities to verify no crashes occur
 */
@RunWith(AndroidJUnit4::class)
class AdminActivitiesTest {

    @Test
    fun testManageClassesActivityOpensWithoutCrashing() {
        // Launch the activity
        val activityScenario = ActivityScenario.launch(ManageClassesActivity::class.java)
        
        // Verify that we're looking at the ManageClassesActivity
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
        
        // Check if recyclerView or 'no classes' message is displayed
        onView(withId(R.id.recyclerViewClasses)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        
        // Close the activity
        activityScenario.close()
    }
    
    @Test
    fun testManageEnrollmentsActivityOpensWithoutCrashing() {
        // Launch the activity
        val activityScenario = ActivityScenario.launch(ManageEnrollmentsActivity::class.java)
        
        // Verify that we're looking at the ManageEnrollmentsActivity
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
        
        // Check if spinner is displayed
        onView(withId(R.id.spinnerClasses)).check(matches(isDisplayed()))
        
        // Close the activity
        activityScenario.close()
    }
    
    @Test
    fun testAdminDashboardNavigation() {
        // Launch the admin dashboard activity
        val activityScenario = ActivityScenario.launch(AdminDashboardActivity::class.java)
        
        // Click on the Manage Classes button
        onView(withId(R.id.btnManageClasses)).perform(click())
        
        // Go back to the admin dashboard
        // (Using pressBack() would be ideal, but requires additional setup)
        val adminScenario = ActivityScenario.launch(AdminDashboardActivity::class.java)
        
        // Click on the Manage Enrollments button
        onView(withId(R.id.btnManageEnrollments)).perform(click())
        
        // Close the activity
        adminScenario.close()
    }
}
