package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/ViewUsersActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/kindergardenmanager/ui/adapter/UserActionListener;", "()V", "adapter", "Lcom/example/kindergardenmanager/ui/adapter/UserListAdapter;", "listView", "Landroid/widget/ListView;", "progressBar", "Landroid/widget/ProgressBar;", "tvNoUsers", "Landroid/widget/TextView;", "userList", "", "Lcom/example/kindergardenmanager/data/model/User;", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "addSampleUsersIfEmpty", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "onUserDeleted", "user", "onUserEdit", "showLoading", "isLoading", "app_release"})
public final class ViewUsersActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.kindergardenmanager.ui.adapter.UserActionListener {
    private com.example.kindergardenmanager.data.repository.UserRepository userRepository;
    private android.widget.ListView listView;
    private android.widget.ProgressBar progressBar;
    private android.widget.TextView tvNoUsers;
    private com.example.kindergardenmanager.ui.adapter.UserListAdapter adapter;
    private java.util.List<com.example.kindergardenmanager.data.model.User> userList;
    
    public ViewUsersActivity() {
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
    
    @java.lang.Override
    public void onUserDeleted(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.User user) {
    }
    
    @java.lang.Override
    public void onUserEdit(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.User user) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    private final void addSampleUsersIfEmpty() {
    }
}