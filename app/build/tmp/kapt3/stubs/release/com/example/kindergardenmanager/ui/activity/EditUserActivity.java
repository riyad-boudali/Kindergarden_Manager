package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/EditUserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnSaveUser", "Landroid/widget/Button;", "currentUser", "Lcom/example/kindergardenmanager/data/model/User;", "etConfirmPassword", "Lcom/google/android/material/textfield/TextInputEditText;", "etEmail", "etFirstName", "etLastName", "etPassword", "etPhoneNumber", "etUsername", "progressBar", "Landroid/widget/ProgressBar;", "rbKitchenStaff", "Landroid/widget/RadioButton;", "rbParent", "rbTeacher", "rgRole", "Landroid/widget/RadioGroup;", "userId", "", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "initializeViews", "", "loadUserData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveUserChanges", "showLoading", "isLoading", "", "app_release"})
public final class EditUserActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.kindergardenmanager.data.repository.UserRepository userRepository;
    private android.widget.ProgressBar progressBar;
    private com.google.android.material.textfield.TextInputEditText etFirstName;
    private com.google.android.material.textfield.TextInputEditText etLastName;
    private com.google.android.material.textfield.TextInputEditText etUsername;
    private com.google.android.material.textfield.TextInputEditText etEmail;
    private com.google.android.material.textfield.TextInputEditText etPhoneNumber;
    private com.google.android.material.textfield.TextInputEditText etPassword;
    private com.google.android.material.textfield.TextInputEditText etConfirmPassword;
    private android.widget.RadioGroup rgRole;
    private android.widget.RadioButton rbTeacher;
    private android.widget.RadioButton rbParent;
    private android.widget.RadioButton rbKitchenStaff;
    private android.widget.Button btnSaveUser;
    private long userId = 0L;
    private com.example.kindergardenmanager.data.model.User currentUser;
    
    public EditUserActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeViews() {
    }
    
    private final void loadUserData() {
    }
    
    private final void saveUserChanges() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
}