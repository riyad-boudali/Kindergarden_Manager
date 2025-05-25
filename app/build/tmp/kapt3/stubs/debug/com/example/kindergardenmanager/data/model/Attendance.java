package com.example.kindergardenmanager.data.model;

import java.lang.System;

/**
 * Entity representing a student's attendance record
 */
@androidx.room.Entity(tableName = "attendance", foreignKeys = {@androidx.room.ForeignKey(entity = com.example.kindergardenmanager.data.model.Child.class, childColumns = {"childId"}, onDelete = 5, parentColumns = {"childId"}), @androidx.room.ForeignKey(entity = com.example.kindergardenmanager.data.model.KindergartenClass.class, childColumns = {"classId"}, onDelete = 5, parentColumns = {"classId"})}, indices = {@androidx.room.Index(value = {"childId"}), @androidx.room.Index(value = {"classId"}), @androidx.room.Index(unique = true, value = {"childId", "date"})})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u000bH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/example/kindergardenmanager/data/model/Attendance;", "", "attendanceId", "", "childId", "classId", "date", "Ljava/util/Date;", "isPresent", "", "notes", "", "(JJJLjava/util/Date;ZLjava/lang/String;)V", "getAttendanceId", "()J", "getChildId", "getClassId", "getDate", "()Ljava/util/Date;", "()Z", "getNotes", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class Attendance {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long attendanceId = 0L;
    private final long childId = 0L;
    private final long classId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date date = null;
    private final boolean isPresent = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String notes = null;
    
    /**
     * Entity representing a student's attendance record
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.model.Attendance copy(long attendanceId, long childId, long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date, boolean isPresent, @org.jetbrains.annotations.Nullable
    java.lang.String notes) {
        return null;
    }
    
    /**
     * Entity representing a student's attendance record
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Entity representing a student's attendance record
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Entity representing a student's attendance record
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Attendance(long attendanceId, long childId, long classId, @org.jetbrains.annotations.NotNull
    java.util.Date date, boolean isPresent, @org.jetbrains.annotations.Nullable
    java.lang.String notes) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getAttendanceId() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getChildId() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getClassId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getDate() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isPresent() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNotes() {
        return null;
    }
}