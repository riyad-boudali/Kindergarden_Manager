package com.example.kindergardenmanager.data.model;

import java.lang.System;

/**
 * Class entity representing a class in the kindergarten
 */
@androidx.room.Entity(tableName = "classes")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u000eH\u00c6\u0003Jg\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\u000e2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0007H\u00d6\u0001J\t\u0010)\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "", "classId", "", "className", "", "ageRangeStart", "", "ageRangeEnd", "teacherId", "capacity", "roomNumber", "description", "isActive", "", "(JLjava/lang/String;IIJILjava/lang/String;Ljava/lang/String;Z)V", "getAgeRangeEnd", "()I", "getAgeRangeStart", "getCapacity", "getClassId", "()J", "getClassName", "()Ljava/lang/String;", "getDescription", "()Z", "getRoomNumber", "getTeacherId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"})
public final class KindergartenClass {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long classId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String className = null;
    private final int ageRangeStart = 0;
    private final int ageRangeEnd = 0;
    private final long teacherId = 0L;
    private final int capacity = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String roomNumber = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String description = null;
    private final boolean isActive = false;
    
    /**
     * Class entity representing a class in the kindergarten
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.model.KindergartenClass copy(long classId, @org.jetbrains.annotations.NotNull
    java.lang.String className, int ageRangeStart, int ageRangeEnd, long teacherId, int capacity, @org.jetbrains.annotations.Nullable
    java.lang.String roomNumber, @org.jetbrains.annotations.Nullable
    java.lang.String description, boolean isActive) {
        return null;
    }
    
    /**
     * Class entity representing a class in the kindergarten
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Class entity representing a class in the kindergarten
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Class entity representing a class in the kindergarten
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public KindergartenClass(long classId, @org.jetbrains.annotations.NotNull
    java.lang.String className, int ageRangeStart, int ageRangeEnd, long teacherId, int capacity, @org.jetbrains.annotations.Nullable
    java.lang.String roomNumber, @org.jetbrains.annotations.Nullable
    java.lang.String description, boolean isActive) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getClassId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getClassName() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getAgeRangeStart() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getAgeRangeEnd() {
        return 0;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getTeacherId() {
        return 0L;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getCapacity() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRoomNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isActive() {
        return false;
    }
}