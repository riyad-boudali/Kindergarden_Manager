package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

/**
 * Activity for admins to manage kindergarten classes
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/ManageClassesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter$ClassAdminClickListener;", "()V", "adapter", "Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter;", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "teacherMap", "", "", "Lcom/example/kindergardenmanager/data/model/User;", "tvNoClasses", "Landroid/widget/TextView;", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "deleteClass", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "loadClasses", "loadTeacherData", "onClassClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClass", "onEditClass", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showLoading", "isLoading", "app_release"})
public final class ManageClassesActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter.ClassAdminClickListener {
    private com.example.kindergardenmanager.data.repository.ClassRepository classRepository;
    private com.example.kindergardenmanager.data.repository.UserRepository userRepository;
    private com.example.kindergardenmanager.data.repository.ChildRepository childRepository;
    private com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter adapter;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView tvNoClasses;
    private final java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> teacherMap = null;
    
    public ManageClassesActivity() {
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
    
    private final void loadTeacherData() {
    }
    
    private final void loadClasses() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    @java.lang.Override
    public void onClassClicked(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
    }
    
    @java.lang.Override
    public void onEditClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
    }
    
    @java.lang.Override
    public void onDeleteClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
    }
    
    private final void deleteClass(com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
    }
}