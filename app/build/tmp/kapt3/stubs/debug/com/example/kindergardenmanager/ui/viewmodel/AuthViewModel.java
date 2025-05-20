package com.example.kindergardenmanager.ui.viewmodel;

import java.lang.System;

/**
 * ViewModel for authentication operations
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010JJ\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/kindergardenmanager/ui/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "(Lcom/example/kindergardenmanager/data/repository/UserRepository;)V", "_authResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/kindergardenmanager/ui/viewmodel/AuthResult;", "authResult", "Landroidx/lifecycle/LiveData;", "getAuthResult", "()Landroidx/lifecycle/LiveData;", "clearAuthResult", "", "login", "emailOrUsername", "", "password", "register", "username", "email", "confirmPassword", "role", "Lcom/example/kindergardenmanager/data/model/UserRole;", "firstName", "lastName", "phoneNumber", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.kindergardenmanager.data.repository.UserRepository userRepository = null;
    private final androidx.lifecycle.MutableLiveData<com.example.kindergardenmanager.ui.viewmodel.AuthResult> _authResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.example.kindergardenmanager.ui.viewmodel.AuthResult> authResult = null;
    
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.kindergardenmanager.ui.viewmodel.AuthResult> getAuthResult() {
        return null;
    }
    
    /**
     * Attempt to log in a user
     */
    public final void login(@org.jetbrains.annotations.NotNull
    java.lang.String emailOrUsername, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    /**
     * Register a new user
     */
    public final void register(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    java.lang.String confirmPassword, @org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.UserRole role, @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @org.jetbrains.annotations.NotNull
    java.lang.String lastName, @org.jetbrains.annotations.Nullable
    java.lang.String phoneNumber) {
    }
    
    /**
     * Clear the current authentication result
     */
    public final void clearAuthResult() {
    }
}