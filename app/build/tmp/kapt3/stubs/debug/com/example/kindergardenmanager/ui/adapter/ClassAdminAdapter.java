package com.example.kindergardenmanager.ui.adapter;

import java.lang.System;

/**
 * Adapter for displaying classes in admin view with edit/delete options
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\"#BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000b\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000fJ\u001a\u0010\u001f\u001a\u00020\u00132\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter$ClassViewHolder;", "context", "Landroid/content/Context;", "classes", "", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "classClickListener", "Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter$ClassAdminClickListener;", "teacherMap", "", "", "Lcom/example/kindergardenmanager/data/model/User;", "studentCountMap", "", "(Landroid/content/Context;Ljava/util/List;Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter$ClassAdminClickListener;Ljava/util/Map;Ljava/util/Map;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateClasses", "newClasses", "updateStudentCount", "classId", "count", "updateTeacherInfo", "newTeacherMap", "", "ClassAdminClickListener", "ClassViewHolder", "app_debug"})
public final class ClassAdminAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter.ClassViewHolder> {
    private final android.content.Context context = null;
    private java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> classes;
    private final com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter.ClassAdminClickListener classClickListener = null;
    private final java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> teacherMap = null;
    private final java.util.Map<java.lang.Long, java.lang.Integer> studentCountMap = null;
    
    public ClassAdminAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> classes, @org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter.ClassAdminClickListener classClickListener, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> teacherMap, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, java.lang.Integer> studentCountMap) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter.ClassViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.ClassAdminAdapter.ClassViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateClasses(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> newClasses) {
    }
    
    public final void updateTeacherInfo(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> newTeacherMap) {
    }
    
    public final void updateStudentCount(long classId, int count) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter$ClassAdminClickListener;", "", "onClassClicked", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "onDeleteClass", "onEditClass", "app_debug"})
    public static abstract interface ClassAdminClickListener {
        
        public abstract void onClassClicked(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass);
        
        public abstract void onEditClass(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass);
        
        public abstract void onDeleteClass(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter$ClassViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/kindergardenmanager/ui/adapter/ClassAdminAdapter;Landroid/view/View;)V", "btnDelete", "Landroid/widget/ImageButton;", "btnEdit", "tvAgeRange", "Landroid/widget/TextView;", "tvCapacityInfo", "tvClassName", "tvTeacher", "bind", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "app_debug"})
    public final class ClassViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView tvClassName = null;
        private final android.widget.TextView tvAgeRange = null;
        private final android.widget.TextView tvTeacher = null;
        private final android.widget.TextView tvCapacityInfo = null;
        private final android.widget.ImageButton btnEdit = null;
        private final android.widget.ImageButton btnDelete = null;
        
        public ClassViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
        }
    }
}