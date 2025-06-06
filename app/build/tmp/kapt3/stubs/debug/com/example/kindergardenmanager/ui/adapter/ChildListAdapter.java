package com.example.kindergardenmanager.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ChildListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/kindergardenmanager/ui/adapter/ChildListAdapter$ChildViewHolder;", "context", "Landroid/content/Context;", "children", "", "Lcom/example/kindergardenmanager/data/model/Child;", "parentMap", "", "", "Lcom/example/kindergardenmanager/data/model/User;", "(Landroid/content/Context;Ljava/util/List;Ljava/util/Map;)V", "calculateAge", "", "birthDate", "Ljava/util/Date;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateChildren", "newChildren", "ChildViewHolder", "app_debug"})
public final class ChildListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.kindergardenmanager.ui.adapter.ChildListAdapter.ChildViewHolder> {
    private final android.content.Context context = null;
    private java.util.List<com.example.kindergardenmanager.data.model.Child> children;
    private final java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> parentMap = null;
    
    public ChildListAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.Child> children, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.Long, com.example.kindergardenmanager.data.model.User> parentMap) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.kindergardenmanager.ui.adapter.ChildListAdapter.ChildViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.ui.adapter.ChildListAdapter.ChildViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateChildren(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.kindergardenmanager.data.model.Child> newChildren) {
    }
    
    private final int calculateAge(java.util.Date birthDate) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/example/kindergardenmanager/ui/adapter/ChildListAdapter$ChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/kindergardenmanager/ui/adapter/ChildListAdapter;Landroid/view/View;)V", "tvAllergies", "Landroid/widget/TextView;", "getTvAllergies", "()Landroid/widget/TextView;", "tvChildAge", "getTvChildAge", "tvChildName", "getTvChildName", "tvParentName", "getTvParentName", "bind", "", "child", "Lcom/example/kindergardenmanager/data/model/Child;", "app_debug"})
    public final class ChildViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvChildName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvChildAge = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvAllergies = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvParentName = null;
        
        public ChildViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvChildName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvChildAge() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvAllergies() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvParentName() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.kindergardenmanager.data.model.Child child) {
        }
    }
}