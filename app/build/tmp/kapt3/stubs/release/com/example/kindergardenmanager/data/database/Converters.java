package com.example.kindergardenmanager.data.database;

import java.lang.System;

/**
 * Type converters for Room to handle custom data types
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/kindergardenmanager/data/database/Converters;", "", "()V", "fromUserRole", "", "role", "Lcom/example/kindergardenmanager/data/model/UserRole;", "toUserRole", "roleName", "app_release"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromUserRole(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.UserRole role) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.example.kindergardenmanager.data.model.UserRole toUserRole(@org.jetbrains.annotations.NotNull
    java.lang.String roleName) {
        return null;
    }
}