package com.example.kindergardenmanager.data.database;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.kindergardenmanager.data.database.Converters.class})
@androidx.room.Database(entities = {com.example.kindergardenmanager.data.model.User.class, com.example.kindergardenmanager.data.model.KindergartenClass.class, com.example.kindergardenmanager.data.model.Child.class, com.example.kindergardenmanager.data.model.Attendance.class, com.example.kindergardenmanager.data.model.Message.class}, version = 4, exportSchema = true)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/kindergardenmanager/data/database/KindergardenDatabase;", "Landroidx/room/RoomDatabase;", "()V", "attendanceDao", "Lcom/example/kindergardenmanager/data/dao/AttendanceDao;", "childDao", "Lcom/example/kindergardenmanager/data/dao/ChildDao;", "classDao", "Lcom/example/kindergardenmanager/data/dao/ClassDao;", "messageDao", "Lcom/example/kindergardenmanager/data/dao/MessageDao;", "userDao", "Lcom/example/kindergardenmanager/data/dao/UserDao;", "Companion", "app_debug"})
public abstract class KindergardenDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.example.kindergardenmanager.data.database.KindergardenDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile
    private static volatile com.example.kindergardenmanager.data.database.KindergardenDatabase INSTANCE;
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    private static final androidx.room.migration.Migration MIGRATION_2_3 = null;
    private static final androidx.room.migration.Migration MIGRATION_3_4 = null;
    
    public KindergardenDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.kindergardenmanager.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.kindergardenmanager.data.dao.ClassDao classDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.kindergardenmanager.data.dao.ChildDao childDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.kindergardenmanager.data.dao.AttendanceDao attendanceDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.kindergardenmanager.data.dao.MessageDao messageDao();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/kindergardenmanager/data/database/KindergardenDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/kindergardenmanager/data/database/KindergardenDatabase;", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "MIGRATION_2_3", "MIGRATION_3_4", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "KindergardenDatabaseCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kindergardenmanager.data.database.KindergardenDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kindergardenmanager.data.database.KindergardenDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/kindergardenmanager/data/database/KindergardenDatabase$Companion$KindergardenDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
        static final class KindergardenDatabaseCallback extends androidx.room.RoomDatabase.Callback {
            private final kotlinx.coroutines.CoroutineScope scope = null;
            
            public KindergardenDatabaseCallback(@org.jetbrains.annotations.NotNull
            kotlinx.coroutines.CoroutineScope scope) {
                super();
            }
            
            @java.lang.Override
            public void onCreate(@org.jetbrains.annotations.NotNull
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
        }
    }
}