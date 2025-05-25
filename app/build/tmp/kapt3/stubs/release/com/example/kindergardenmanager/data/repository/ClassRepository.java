package com.example.kindergardenmanager.data.repository;

import java.lang.System;

/**
 * Repository for handling classroom operations
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rJ\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u0012\u001a\u00020\u0006J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u0006J\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "", "classDao", "Lcom/example/kindergardenmanager/data/dao/ClassDao;", "(Lcom/example/kindergardenmanager/data/dao/ClassDao;)V", "addClass", "", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "(Lcom/example/kindergardenmanager/data/model/KindergartenClass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteClass", "", "getActiveClasses", "Landroidx/lifecycle/LiveData;", "", "getAllClasses", "getChildCountForClass", "", "classId", "getClassById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassesByTeacherId", "teacherId", "updateClass", "app_release"})
public final class ClassRepository {
    private final com.example.kindergardenmanager.data.dao.ClassDao classDao = null;
    
    public ClassRepository(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.dao.ClassDao classDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteClass(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getClassById(long classId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.KindergartenClass> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass>> getClassesByTeacherId(long teacherId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass>> getAllClasses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getChildCountForClass(long classId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.KindergartenClass>> getActiveClasses() {
        return null;
    }
}