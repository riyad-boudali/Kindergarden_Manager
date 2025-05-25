package com.example.kindergardenmanager.ui.adapter;

import java.lang.System;

/**
 * Adapter for displaying and managing attendance list
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002&\'B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000eJ\u001a\u0010\"\u001a\u00020\u00182\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0014J\u0014\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter$AttendanceViewHolder;", "context", "Landroid/content/Context;", "children", "", "Lcom/example/kindergardenmanager/data/model/Child;", "attendanceListener", "Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter$AttendanceListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter$AttendanceListener;)V", "attendanceStatus", "", "", "", "calculateAge", "", "birthDate", "Ljava/util/Date;", "getAllAttendanceStatuses", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAttendanceStatus", "childId", "isPresent", "updateAllAttendanceStatuses", "statuses", "updateChildren", "newChildren", "AttendanceListener", "AttendanceViewHolder", "app_release"})
public final class AttendanceAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.kindergardenmanager.ui.adapter.AttendanceAdapter.AttendanceViewHolder> {
    private final android.content.Context context = null;
    private java.util.List<com.example.kindergardenmanager.data.model.Child> children;
    private final com.example.kindergardenmanager.ui.adapter.AttendanceAdapter.AttendanceListener attendanceListener = null;
    private final java.util.Map<java.lang.Long, java.lang.Boolean> attendanceStatus = null;
    
    public AttendanceAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.Child> children, @org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.AttendanceAdapter.AttendanceListener attendanceListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.kindergardenmanager.ui.adapter.AttendanceAdapter.AttendanceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.AttendanceAdapter.AttendanceViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateChildren(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.Child> newChildren) {
    }
    
    public final void setAttendanceStatus(long childId, boolean isPresent) {
    }
    
    public final void updateAllAttendanceStatuses(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, java.lang.Boolean> statuses) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.Long, java.lang.Boolean> getAllAttendanceStatuses() {
        return null;
    }
    
    private final java.lang.String calculateAge(java.util.Date birthDate) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter$AttendanceListener;", "", "onAttendanceChanged", "", "childId", "", "isPresent", "", "app_release"})
    public static abstract interface AttendanceListener {
        
        public abstract void onAttendanceChanged(long childId, boolean isPresent);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter$AttendanceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter;Landroid/view/View;)V", "cbPresent", "Landroid/widget/CheckBox;", "tvChildAge", "Landroid/widget/TextView;", "tvChildName", "bind", "", "child", "Lcom/example/kindergardenmanager/data/model/Child;", "isPresent", "", "app_release"})
    public final class AttendanceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView tvChildName = null;
        private final android.widget.TextView tvChildAge = null;
        private final android.widget.CheckBox cbPresent = null;
        
        public AttendanceViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.Child child, boolean isPresent) {
        }
    }
}