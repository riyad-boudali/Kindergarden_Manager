package com.example.kindergardenmanager.data.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0017\u001a\u00020\u0018H\'J\u0019\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J#\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/kindergardenmanager/data/dao/UserDao;", "", "deleteUser", "", "user", "Lcom/example/kindergardenmanager/data/model/User;", "(Lcom/example/kindergardenmanager/data/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUsers", "Landroidx/lifecycle/LiveData;", "", "getUserByEmail", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserByEmailOrUsername", "emailOrUsername", "getUserById", "userId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserByUsername", "username", "getUsersByRole", "role", "Lcom/example/kindergardenmanager/data/model/UserRole;", "insertUser", "login", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "app_release"})
public abstract interface UserDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 3)
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM users WHERE userId = :userId")
    public abstract java.lang.Object getUserById(long userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.User> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM users WHERE email = :email LIMIT 1")
    public abstract java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.User> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM users WHERE username = :username LIMIT 1")
    public abstract java.lang.Object getUserByUsername(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.User> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM users WHERE email = :emailOrUsername OR username = :emailOrUsername LIMIT 1")
    public abstract java.lang.Object getUserByEmailOrUsername(@org.jetbrains.annotations.NotNull
    java.lang.String emailOrUsername, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.User> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM users WHERE role = :role")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.User>> getUsersByRole(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.UserRole role);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM users")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.User>> getAllUsers();
    
    /**
     * Authentication method to verify login credentials
     */
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM users WHERE (email = :emailOrUsername OR username = :emailOrUsername) AND password = :password LIMIT 1")
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull
    java.lang.String emailOrUsername, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.User> continuation);
}