package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authViewModel", "Lcom/example/kindergardenmanager/ui/viewmodel/AuthViewModel;", "etConfirmPassword", "Lcom/google/android/material/textfield/TextInputEditText;", "etEmail", "etFirstName", "etLastName", "etPassword", "etPhone", "etUsername", "progressBar", "Landroid/view/View;", "rgUserRole", "Landroid/widget/RadioGroup;", "sessionManager", "Lcom/example/kindergardenmanager/util/SessionManager;", "getUserRoleFromRadioGroup", "Lcom/example/kindergardenmanager/data/model/UserRole;", "navigateToDashboard", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "registerUser", "showLoading", "isLoading", "", "app_release"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.kindergardenmanager.ui.viewmodel.AuthViewModel authViewModel;
    private com.example.kindergardenmanager.util.SessionManager sessionManager;
    private com.google.android.material.textfield.TextInputEditText etFirstName;
    private com.google.android.material.textfield.TextInputEditText etLastName;
    private com.google.android.material.textfield.TextInputEditText etUsername;
    private com.google.android.material.textfield.TextInputEditText etEmail;
    private com.google.android.material.textfield.TextInputEditText etPhone;
    private com.google.android.material.textfield.TextInputEditText etPassword;
    private com.google.android.material.textfield.TextInputEditText etConfirmPassword;
    private android.widget.RadioGroup rgUserRole;
    private android.view.View progressBar;
    
    public RegisterActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void registerUser() {
    }
    
    private final com.example.kindergardenmanager.data.model.UserRole getUserRoleFromRadioGroup() {
        return null;
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    private final void navigateToDashboard() {
    }
}