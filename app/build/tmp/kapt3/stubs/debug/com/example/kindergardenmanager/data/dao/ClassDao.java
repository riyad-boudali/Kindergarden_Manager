package com.example.kindergardenmanager.data.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eH\'J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0012\u001a\u00020\u000eH\'J\u0019\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/kindergardenmanager/data/dao/ClassDao;", "", "deleteClass", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "(Lcom/example/kindergardenmanager/data/model/KindergartenClass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveClasses", "Landroidx/lifecycle/LiveData;", "", "getAllClasses", "getChildCountForClass", "", "classId", "", "getClassById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassesByTeacherId", "teacherId", "insertClass", "updateClass", "app_debug"})
public abstract interface ClassDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 3)
    public abstract java.lang.Object insertClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM classes WHERE classId = :classId")
    public abstract java.lang.Object getClassById(long classId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.KindergartenClass> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM classes WHERE teacherId = :teacherId")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass>> getClassesByTeacherId(long teacherId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM classes")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass>> getAllClasses();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM children WHERE classId = :classId")
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getChildCountForClass(long classId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM classes WHERE isActive = 1")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass>> getActiveClasses();
}