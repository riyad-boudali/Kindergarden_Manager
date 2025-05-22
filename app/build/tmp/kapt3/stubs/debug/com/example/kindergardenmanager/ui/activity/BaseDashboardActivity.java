package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

/**
 * Base dashboard activity that provides common functionality for all role-specific dashboards
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0004J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0004J\u001a\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u001e"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/BaseDashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "sessionManager", "Lcom/example/kindergardenmanager/util/SessionManager;", "getSessionManager", "()Lcom/example/kindergardenmanager/util/SessionManager;", "setSessionManager", "(Lcom/example/kindergardenmanager/util/SessionManager;)V", "logout", "", "navigateToLogin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setupSignOutButton", "signOutButton", "Landroid/widget/Button;", "setupToolbar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "title", "", "app_debug"})
public abstract class BaseDashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    protected com.example.kindergardenmanager.util.SessionManager sessionManager;
    
    public BaseDashboardActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    protected final com.example.kindergardenmanager.util.SessionManager getSessionManager() {
        return null;
    }
    
    protected final void setSessionManager(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.util.SessionManager p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * Set up toolbar with back button
     */
    protected final void setupToolbar(@org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.Toolbar toolbar, @org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    /**
     * Logout the user and navigate to login screen
     */
    protected final void logout() {
    }
    
    /**
     * Navigate to the login screen
     */
    private final void navigateToLogin() {
    }
    
    /**
     * Set up the 'Sign Out' button functionality
     */
    protected final void setupSignOutButton(@org.jetbrains.annotations.NotNull
    android.widget.Button signOutButton) {
    }
}