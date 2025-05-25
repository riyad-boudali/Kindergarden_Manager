package com.example.kindergardenmanager.ui.adapter;

import java.lang.System;

/**
 * Adapter for displaying children with enrollment actions
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002#$BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0014\u0010\u001f\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001a\u0010!\u001a\u00020\u00182\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter$EnrollmentViewHolder;", "context", "Landroid/content/Context;", "children", "", "Lcom/example/kindergardenmanager/data/model/Child;", "enrollmentListener", "Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter$EnrollmentListener;", "isEnrolled", "", "parentMap", "", "", "Lcom/example/kindergardenmanager/data/model/User;", "(Landroid/content/Context;Ljava/util/List;Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter$EnrollmentListener;ZLjava/util/Map;)V", "calculateAge", "", "birthDate", "Ljava/util/Date;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateChildren", "newChildren", "updateParentInfo", "newParentMap", "EnrollmentListener", "EnrollmentViewHolder", "app_release"})
public final class EnrollmentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter.EnrollmentViewHolder> {
    private final android.content.Context context = null;
    private java.util.List<com.example.kindergardenmanager.data.model.Child> children;
    private final com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter.EnrollmentListener enrollmentListener = null;
    private final boolean isEnrolled = false;
    private final java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> parentMap = null;
    
    public EnrollmentAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.Child> children, @org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter.EnrollmentListener enrollmentListener, boolean isEnrolled, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> parentMap) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter.EnrollmentViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.EnrollmentAdapter.EnrollmentViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateChildren(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.Child> newChildren) {
    }
    
    public final void updateParentInfo(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> newParentMap) {
    }
    
    private final java.lang.String calculateAge(java.util.Date birthDate) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter$EnrollmentListener;", "", "onEnrollChild", "", "child", "Lcom/example/kindergardenmanager/data/model/Child;", "onUnenrollChild", "app_release"})
    public static abstract interface EnrollmentListener {
        
        public abstract void onEnrollChild(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.Child child);
        
        public abstract void onUnenrollChild(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.Child child);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter$EnrollmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/kindergardenmanager/ui/adapter/EnrollmentAdapter;Landroid/view/View;)V", "btnAction", "Landroid/widget/Button;", "tvChildAge", "Landroid/widget/TextView;", "tvChildName", "tvParentInfo", "bind", "", "child", "Lcom/example/kindergardenmanager/data/model/Child;", "app_release"})
    public final class EnrollmentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView tvChildName = null;
        private final android.widget.TextView tvChildAge = null;
        private final android.widget.TextView tvParentInfo = null;
        private final android.widget.Button btnAction = null;
        
        public EnrollmentViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.Child child) {
        }
    }
}