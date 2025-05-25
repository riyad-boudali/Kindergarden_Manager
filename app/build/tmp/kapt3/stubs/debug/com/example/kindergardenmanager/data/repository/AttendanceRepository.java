package com.example.kindergardenmanager.data.repository;

import java.lang.System;

/**
 * Repository class for handling attendance-related operations
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\u0012\u001a\u00020\u0006J\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ*\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150\u00142\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fJ\u001b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\'\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\u0006\u0010\u0012\u001a\u00020\u0006J=\u0010 \u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/kindergardenmanager/data/repository/AttendanceRepository;", "", "attendanceDao", "Lcom/example/kindergardenmanager/data/dao/AttendanceDao;", "(Lcom/example/kindergardenmanager/data/dao/AttendanceDao;)V", "addAttendance", "", "attendance", "Lcom/example/kindergardenmanager/data/model/Attendance;", "(Lcom/example/kindergardenmanager/data/model/Attendance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAttendance", "", "deleteAttendanceForClassAndDate", "classId", "date", "Ljava/util/Date;", "(JLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceByChildAndDate", "childId", "getAttendanceByChildId", "Landroidx/lifecycle/LiveData;", "", "getAttendanceByClassAndDate", "getAttendanceByClassAndDateRange", "startDate", "endDate", "getAttendanceById", "attendanceId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceWithChildInfo", "getChildPresentDaysCount", "", "markAttendance", "isPresent", "", "notes", "", "(JJLjava/util/Date;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAttendance", "app_debug"})
public final class AttendanceRepository {
    private final com.example.kindergardenmanager.data.dao.AttendanceDao attendanceDao = null;
    
    public AttendanceRepository(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.dao.AttendanceDao attendanceDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addAttendance(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Attendance attendance, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateAttendance(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Attendance attendance, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteAttendance(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Attendance attendance, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAttendanceById(long attendanceId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Attendance> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Attendance>> getAttendanceByChildId(long childId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Attendance>> getAttendanceByClassAndDate(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAttendanceByChildAndDate(long childId, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Attendance> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Attendance>> getAttendanceByClassAndDateRange(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date startDate, @org.jetbrains.annotations.NotNull
    java.util.Date endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getChildPresentDaysCount(long childId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAttendanceWithChildInfo(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.kindergardenmanager.data.model.Attendance>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteAttendanceForClassAndDate(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object markAttendance(long classId, long childId, @org.jetbrains.annotations.NotNull
    java.util.Date date, boolean isPresent, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}