package com.example.kindergardenmanager.util;

import java.lang.System;

/**
 * SessionManager handles user session data like authentication state
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/kindergardenmanager/util/SessionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "kotlin.jvm.PlatformType", "preferences", "Landroid/content/SharedPreferences;", "createLoginSession", "", "user", "Lcom/example/kindergardenmanager/data/model/User;", "getUserDetails", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getUserId", "", "getUserRole", "Lcom/example/kindergardenmanager/data/model/UserRole;", "isLoggedIn", "", "logoutUser", "Companion", "app_debug"})
public final class SessionManager {
    private final android.content.SharedPreferences preferences = null;
    private final android.content.SharedPreferences.Editor editor = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.kindergardenmanager.util.SessionManager.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREF_NAME = "KindergartenAppSession";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_IS_LOGGED_IN = "isLoggedIn";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_USER_ID = "userId";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_USERNAME = "username";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_EMAIL = "email";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_FIRST_NAME = "firstName";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_LAST_NAME = "lastName";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_ROLE = "role";
    
    public SessionManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Save user login session
     */
    public final void createLoginSession(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.User user) {
    }
    
    /**
     * Check if user is logged in
     */
    public final boolean isLoggedIn() {
        return false;
    }
    
    /**
     * Get logged in user details
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, java.lang.String> getUserDetails() {
        return null;
    }
    
    /**
     * Get current user role
     */
    @org.jetbrains.annotations.Nullable
    public final com.example.kindergardenmanager.data.model.UserRole getUserRole() {
        return null;
    }
    
    /**
     * Get current user ID
     */
    public final long getUserId() {
        return 0L;
    }
    
    /**
     * Clear user session data
     */
    public final void logoutUser() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/kindergardenmanager/util/SessionManager$Companion;", "", "()V", "KEY_EMAIL", "", "KEY_FIRST_NAME", "KEY_IS_LOGGED_IN", "KEY_LAST_NAME", "KEY_ROLE", "KEY_USERNAME", "KEY_USER_ID", "PREF_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}