package com.example.kindergardenmanager.data.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\u000e\u001a\u00020\tH\'J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\'J,\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\'J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0006\u0010\u000e\u001a\u00020\tH\'J\u0019\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/kindergardenmanager/data/dao/AttendanceDao;", "", "deleteAttendance", "", "attendance", "Lcom/example/kindergardenmanager/data/model/Attendance;", "(Lcom/example/kindergardenmanager/data/model/Attendance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAttendanceForClassAndDate", "classId", "", "date", "Ljava/util/Date;", "(JLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceByChildAndDate", "childId", "getAttendanceByChildId", "Landroidx/lifecycle/LiveData;", "", "getAttendanceByClassAndDate", "getAttendanceByClassAndDateRange", "startDate", "endDate", "getAttendanceById", "attendanceId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceWithChildInfo", "getChildPresentDaysCount", "", "insertAttendance", "updateAttendance", "app_release"})
public abstract interface AttendanceDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertAttendance(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Attendance attendance, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateAttendance(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Attendance attendance, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteAttendance(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Attendance attendance, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE attendanceId = :attendanceId")
    public abstract java.lang.Object getAttendanceById(long attendanceId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Attendance> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE childId = :childId")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Attendance>> getAttendanceByChildId(long childId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE classId = :classId AND date = :date")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Attendance>> getAttendanceByClassAndDate(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE childId = :childId AND date = :date")
    public abstract java.lang.Object getAttendanceByChildAndDate(long childId, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Attendance> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE classId = :classId AND date BETWEEN :startDate AND :endDate")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Attendance>> getAttendanceByClassAndDateRange(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date startDate, @org.jetbrains.annotations.NotNull
    java.util.Date endDate);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance WHERE childId = :childId AND isPresent = 1")
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getChildPresentDaysCount(long childId);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE classId = :classId AND date = :date")
    public abstract java.lang.Object getAttendanceWithChildInfo(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.kindergardenmanager.data.model.Attendance>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM attendance WHERE classId = :classId AND date = :date")
    @androidx.room.Transaction
    public abstract java.lang.Object deleteAttendanceForClassAndDate(long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}