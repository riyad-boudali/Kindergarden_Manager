package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

/**
 * Activity for administrators to view class details and enrolled students
 * Simplified implementation to fix crashes
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/ClassDetailAdminActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnEditClass", "Landroid/widget/Button;", "btnManageEnrollments", "cardDetails", "Landroidx/cardview/widget/CardView;", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "classId", "", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerViewStudents", "Landroidx/recyclerview/widget/RecyclerView;", "tvAgeRange", "Landroid/widget/TextView;", "tvCapacity", "tvClassName", "tvDescription", "tvNoStudents", "tvRoom", "tvStatus", "tvTeacherName", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "initializeViews", "", "loadBasicClassInfo", "loadStudentList", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setupButtons", "showLoading", "isLoading", "app_debug"})
public final class ClassDetailAdminActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.kindergardenmanager.data.repository.ClassRepository classRepository;
    private com.example.kindergardenmanager.data.repository.UserRepository userRepository;
    private com.example.kindergardenmanager.data.repository.ChildRepository childRepository;
    private android.widget.TextView tvClassName;
    private android.widget.TextView tvAgeRange;
    private android.widget.TextView tvTeacherName;
    private android.widget.TextView tvCapacity;
    private android.widget.TextView tvRoom;
    private android.widget.TextView tvDescription;
    private android.widget.TextView tvStatus;
    private androidx.cardview.widget.CardView cardDetails;
    private androidx.recyclerview.widget.RecyclerView recyclerViewStudents;
    private android.widget.TextView tvNoStudents;
    private android.widget.ProgressBar progressBar;
    private android.widget.Button btnEditClass;
    private android.widget.Button btnManageEnrollments;
    private long classId = 0L;
    
    public ClassDetailAdminActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeViews() {
    }
    
    private final void setupButtons() {
    }
    
    private final void loadBasicClassInfo() {
    }
    
    private final void loadStudentList(long classId) {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
}