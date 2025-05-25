package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

/**
 * Activity for teachers to select which class to take attendance for
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/ViewClassesForAttendanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter$ClassClickListener;", "()V", "adapter", "Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter;", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sessionManager", "Lcom/example/kindergardenmanager/util/SessionManager;", "tvNoClasses", "Landroid/widget/TextView;", "loadTeacherClasses", "", "teacherId", "", "onClassClicked", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showLoading", "isLoading", "app_release"})
public final class ViewClassesForAttendanceActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.kindergardenmanager.ui.adapter.ClassListAdapter.ClassClickListener {
    private com.example.kindergardenmanager.data.repository.ClassRepository classRepository;
    private com.example.kindergardenmanager.data.repository.ChildRepository childRepository;
    private com.example.kindergardenmanager.util.SessionManager sessionManager;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView tvNoClasses;
    private com.example.kindergardenmanager.ui.adapter.ClassListAdapter adapter;
    
    public ViewClassesForAttendanceActivity() {
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
    
    private final void loadTeacherClasses(long teacherId) {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    @java.lang.Override
    public void onClassClicked(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
    }
}