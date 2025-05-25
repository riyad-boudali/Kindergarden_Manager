package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adminCredentials", "", "", "authViewModel", "Lcom/example/kindergardenmanager/ui/viewmodel/AuthViewModel;", "etEmailUsername", "Lcom/google/android/material/textfield/TextInputEditText;", "etPassword", "progressBar", "Landroid/view/View;", "sessionManager", "Lcom/example/kindergardenmanager/util/SessionManager;", "navigateToDashboard", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performLogin", "showError", "message", "showLoading", "isLoading", "", "app_release"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.kindergardenmanager.ui.viewmodel.AuthViewModel authViewModel;
    private com.example.kindergardenmanager.util.SessionManager sessionManager;
    private com.google.android.material.textfield.TextInputEditText etEmailUsername;
    private com.google.android.material.textfield.TextInputEditText etPassword;
    private android.view.View progressBar;
    private final java.util.Map<java.lang.String, java.lang.String> adminCredentials = null;
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void performLogin() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    private final void navigateToDashboard() {
    }
}