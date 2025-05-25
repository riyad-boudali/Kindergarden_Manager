package com.example.kindergardenmanager.data.model;

import java.lang.System;

/**
 * Child entity representing a child in the kindergarten
 */
@androidx.room.Entity(tableName = "children", foreignKeys = {@androidx.room.ForeignKey(entity = com.example.kindergardenmanager.data.model.User.class, childColumns = {"parentId"}, onDelete = 5, parentColumns = {"userId"}), @androidx.room.ForeignKey(entity = com.example.kindergardenmanager.data.model.KindergartenClass.class, childColumns = {"classId"}, onDelete = 3, parentColumns = {"classId"})}, indices = {@androidx.room.Index(value = {"parentId"}), @androidx.room.Index(value = {"classId"})})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\bH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0011H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u008e\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001\u00a2\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u000205H\u00d6\u0001J\t\u00106\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018\u00a8\u00067"}, d2 = {"Lcom/example/kindergardenmanager/data/model/Child;", "", "childId", "", "firstName", "", "lastName", "birthDate", "Ljava/util/Date;", "parentId", "classId", "gender", "allergies", "medicalNotes", "emergencyContact", "enrollmentDate", "isActive", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Date;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)V", "getAllergies", "()Ljava/lang/String;", "getBirthDate", "()Ljava/util/Date;", "getChildId", "()J", "getClassId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEmergencyContact", "getEnrollmentDate", "getFirstName", "getGender", "()Z", "getLastName", "getMedicalNotes", "getParentId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Date;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Z)Lcom/example/kindergardenmanager/data/model/Child;", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class Child {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long childId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String firstName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String lastName = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date birthDate = null;
    private final long parentId = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long classId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String gender = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String allergies = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String medicalNotes = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String emergencyContact = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date enrollmentDate = null;
    private final boolean isActive = false;
    
    /**
     * Child entity representing a child in the kindergarten
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.model.Child copy(long childId, @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @org.jetbrains.annotations.NotNull
    java.lang.String lastName, @org.jetbrains.annotations.NotNull
    java.util.Date birthDate, long parentId, @org.jetbrains.annotations.Nullable
    java.lang.Long classId, @org.jetbrains.annotations.NotNull
    java.lang.String gender, @org.jetbrains.annotations.Nullable
    java.lang.String allergies, @org.jetbrains.annotations.Nullable
    java.lang.String medicalNotes, @org.jetbrains.annotations.Nullable
    java.lang.String emergencyContact, @org.jetbrains.annotations.NotNull
    java.util.Date enrollmentDate, boolean isActive) {
        return null;
    }
    
    /**
     * Child entity representing a child in the kindergarten
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Child entity representing a child in the kindergarten
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Child entity representing a child in the kindergarten
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Child(long childId, @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @org.jetbrains.annotations.NotNull
    java.lang.String lastName, @org.jetbrains.annotations.NotNull
    java.util.Date birthDate, long parentId, @org.jetbrains.annotations.Nullable
    java.lang.Long classId, @org.jetbrains.annotations.NotNull
    java.lang.String gender, @org.jetbrains.annotations.Nullable
    java.lang.String allergies, @org.jetbrains.annotations.Nullable
    java.lang.String medicalNotes, @org.jetbrains.annotations.Nullable
    java.lang.String emergencyContact, @org.jetbrains.annotations.NotNull
    java.util.Date enrollmentDate, boolean isActive) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getChildId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getBirthDate() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getParentId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getClassId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGender() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAllergies() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMedicalNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEmergencyContact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getEnrollmentDate() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean isActive() {
        return false;
    }
}