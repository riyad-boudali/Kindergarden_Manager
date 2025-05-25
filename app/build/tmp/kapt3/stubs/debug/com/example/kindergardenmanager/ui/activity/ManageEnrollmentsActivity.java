package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

/**
 * Activity for managing student enrollments in classes
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\'H\u0002J\b\u0010+\u001a\u00020\'H\u0002J\b\u0010,\u001a\u00020\'H\u0002J\u0012\u0010-\u001a\u00020\'2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u00020\'2\u0006\u00101\u001a\u00020\u0006H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\'2\u0006\u00101\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\'H\u0002J\u0010\u00108\u001a\u00020\'2\u0006\u00109\u001a\u000203H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/ManageEnrollmentsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter$EnrollmentListener;", "()V", "allAvailableChildren", "", "Lcom/example/kindergardenmanager/data/model/Child;", "availableAdapter", "Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter;", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "classList", "", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "enrolledAdapter", "etSearchStudents", "Landroid/widget/EditText;", "parentMap", "", "", "Lcom/example/kindergardenmanager/data/model/User;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerViewAvailableStudents", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewEnrolledStudents", "selectedClassId", "spinnerClasses", "Landroid/widget/Spinner;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "tvNoAvailableStudents", "Landroid/widget/TextView;", "tvNoEnrolledStudents", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "filterAvailableStudents", "", "query", "", "loadClasses", "loadEnrollmentData", "loadParentData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEnrollChild", "child", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onUnenrollChild", "setupSearch", "showLoading", "isLoading", "app_debug"})
public final class ManageEnrollmentsActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter.EnrollmentListener {
    private com.example.kindergardenmanager.data.repository.ClassRepository classRepository;
    private com.example.kindergardenmanager.data.repository.ChildRepository childRepository;
    private com.example.kindergardenmanager.data.repository.UserRepository userRepository;
    private androidx.appcompat.widget.Toolbar toolbar;
    private android.widget.Spinner spinnerClasses;
    private androidx.recyclerview.widget.RecyclerView recyclerViewEnrolledStudents;
    private androidx.recyclerview.widget.RecyclerView recyclerViewAvailableStudents;
    private android.widget.TextView tvNoEnrolledStudents;
    private android.widget.TextView tvNoAvailableStudents;
    private android.widget.ProgressBar progressBar;
    private android.widget.EditText etSearchStudents;
    private java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> classList;
    private long selectedClassId = 0L;
    private final java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> parentMap = null;
    private com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter enrolledAdapter;
    private com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter availableAdapter;
    private java.util.List<com.example.kindergardenmanager.data.model.Child> allAvailableChildren;
    
    public ManageEnrollmentsActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void loadParentData() {
    }
    
    /**
     * Loads all classes from the database and populates spinner
     *
     * This method includes error handling to prevent crashes when:
     * 1. The database is not properly initialized
     * 2. The classes table doesn't exist or has schema issues
     * 3. LiveData observer encounters errors
     *
     * On error, it shows a user-friendly message and finishes the activity
     * to prevent further crashes down the line.
     */
    private final void loadClasses() {
    }
    
    private final void setupSearch() {
    }
    
    private final void filterAvailableStudents(java.lang.String query) {
    }
    
    private final void loadEnrollmentData() {
    }
    
    @java.lang.Override
    public void onEnrollChild(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Child child) {
    }
    
    @java.lang.Override
    public void onUnenrollChild(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Child child) {
    }
    
    private final void showLoading(boolean isLoading) {
    }
}