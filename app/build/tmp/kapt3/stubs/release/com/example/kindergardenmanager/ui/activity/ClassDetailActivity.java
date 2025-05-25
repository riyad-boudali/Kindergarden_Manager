package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/ClassDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/kindergardenmanager/ui/adapter/ChildListAdapter;", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "classId", "", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "parentMap", "", "Lcom/example/kindergardenmanager/data/model/User;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerViewStudents", "Landroidx/recyclerview/widget/RecyclerView;", "tvAgeRange", "Landroid/widget/TextView;", "tvCapacity", "tvClassName", "tvDescription", "tvNoStudents", "tvRoomNumber", "displayClassDetails", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "loadClassDetails", "loadClassStudents", "loadParentData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showLoading", "isLoading", "app_release"})
public final class ClassDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.kindergardenmanager.data.repository.ClassRepository classRepository;
    private com.example.kindergardenmanager.data.repository.ChildRepository childRepository;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView tvClassName;
    private android.widget.TextView tvAgeRange;
    private android.widget.TextView tvRoomNumber;
    private android.widget.TextView tvCapacity;
    private android.widget.TextView tvDescription;
    private android.widget.TextView tvNoStudents;
    private androidx.recyclerview.widget.RecyclerView recyclerViewStudents;
    private com.example.kindergardenmanager.ui.adapter.ChildListAdapter adapter;
    private final java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> parentMap = null;
    private long classId = 0L;
    
    public ClassDetailActivity() {
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
    
    private final void loadClassDetails() {
    }
    
    private final void displayClassDetails(com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
    }
    
    private final void loadClassStudents() {
    }
    
    private final void loadParentData() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
}