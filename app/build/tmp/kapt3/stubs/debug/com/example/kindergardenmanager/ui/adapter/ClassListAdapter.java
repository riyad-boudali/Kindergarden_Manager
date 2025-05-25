package com.example.kindergardenmanager.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000eJ\u0014\u0010\u001b\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter$ClassViewHolder;", "context", "Landroid/content/Context;", "classes", "", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "listener", "Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter$ClassClickListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter$ClassClickListener;)V", "childCountMap", "", "", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateChildCount", "classId", "count", "updateClasses", "newClasses", "ClassClickListener", "ClassViewHolder", "app_debug"})
public final class ClassListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.kindergardenmanager.ui.adapter.ClassListAdapter.ClassViewHolder> {
    private final android.content.Context context = null;
    private java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> classes;
    private final com.example.kindergardenmanager.ui.adapter.ClassListAdapter.ClassClickListener listener = null;
    private final java.util.Map<java.lang.Long, java.lang.Integer> childCountMap = null;
    
    public ClassListAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> classes, @org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.ClassListAdapter.ClassClickListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.kindergardenmanager.ui.adapter.ClassListAdapter.ClassViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.ClassListAdapter.ClassViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateChildCount(long classId, int count) {
    }
    
    public final void updateClasses(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass> newClasses) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter$ClassClickListener;", "", "onClassClicked", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "app_debug"})
    public static abstract interface ClassClickListener {
        
        public abstract void onClassClicked(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter$ClassViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/kindergardenmanager/ui/adapter/ClassListAdapter;Landroid/view/View;)V", "btnViewDetails", "Landroid/widget/Button;", "getBtnViewDetails", "()Landroid/widget/Button;", "tvAgeRange", "Landroid/widget/TextView;", "getTvAgeRange", "()Landroid/widget/TextView;", "tvClassName", "getTvClassName", "tvKidsCount", "getTvKidsCount", "tvRoomNumber", "getTvRoomNumber", "bind", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "app_debug"})
    public final class ClassViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvClassName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAgeRange = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvKidsCount = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvRoomNumber = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.Button btnViewDetails = null;
        
        public ClassViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvClassName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvAgeRange() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvKidsCount() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvRoomNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.Button getBtnViewDetails() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass) {
        }
    }
}