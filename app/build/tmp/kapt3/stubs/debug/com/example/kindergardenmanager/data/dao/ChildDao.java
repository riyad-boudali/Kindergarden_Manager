package com.example.kindergardenmanager.data.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0010\u001a\u00020\rH\'J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0012\u001a\u00020\rH\'J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/kindergardenmanager/data/dao/ChildDao;", "", "deleteChild", "", "child", "Lcom/example/kindergardenmanager/data/model/Child;", "(Lcom/example/kindergardenmanager/data/model/Child;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveChildren", "Landroidx/lifecycle/LiveData;", "", "getAllChildren", "getChildById", "childId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChildrenByClassId", "classId", "getChildrenByParentId", "parentId", "getChildrenCountByClassId", "", "insertChild", "updateChild", "app_debug"})
public abstract interface ChildDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 3)
    public abstract java.lang.Object insertChild(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Child child, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateChild(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Child child, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteChild(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Child child, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM children WHERE childId = :childId")
    public abstract java.lang.Object getChildById(long childId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Child> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM children WHERE parentId = :parentId")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Child>> getChildrenByParentId(long parentId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM children WHERE classId = :classId")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Child>> getChildrenByClassId(long classId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM children")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Child>> getAllChildren();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM children WHERE isActive = 1")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Child>> getActiveChildren();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT COUNT(*) FROM children WHERE classId = :classId")
    public abstract java.lang.Object getChildrenCountByClassId(long classId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
}