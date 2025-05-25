package com.example.kindergardenmanager;

import java.lang.System;

/**
 * Application class for global application state
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"\u00a8\u0006$"}, d2 = {"Lcom/example/kindergardenmanager/KindergardenApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "attendanceRepository", "Lcom/example/kindergardenmanager/data/repository/AttendanceRepository;", "getAttendanceRepository", "()Lcom/example/kindergardenmanager/data/repository/AttendanceRepository;", "attendanceRepository$delegate", "Lkotlin/Lazy;", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "getChildRepository", "()Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "childRepository$delegate", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "getClassRepository", "()Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "classRepository$delegate", "database", "Lcom/example/kindergardenmanager/data/database/KindergardenDatabase;", "getDatabase", "()Lcom/example/kindergardenmanager/data/database/KindergardenDatabase;", "database$delegate", "messageRepository", "Lcom/example/kindergardenmanager/data/repository/MessageRepository;", "getMessageRepository", "()Lcom/example/kindergardenmanager/data/repository/MessageRepository;", "messageRepository$delegate", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "getUserRepository", "()Lcom/example/kindergardenmanager/data/repository/UserRepository;", "userRepository$delegate", "app_debug"})
public final class KindergardenApplication extends android.app.Application {
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy userRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy classRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy childRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy attendanceRepository$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy messageRepository$delegate = null;
    
    public KindergardenApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.database.KindergardenDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.repository.UserRepository getUserRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.repository.ClassRepository getClassRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.repository.ChildRepository getChildRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.repository.AttendanceRepository getAttendanceRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.kindergardenmanager.data.repository.MessageRepository getMessageRepository() {
        return null;
    }
}