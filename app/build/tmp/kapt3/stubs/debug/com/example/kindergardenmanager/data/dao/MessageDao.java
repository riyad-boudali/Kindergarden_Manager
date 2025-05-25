package com.example.kindergardenmanager.data.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\'J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/kindergardenmanager/data/dao/MessageDao;", "", "deleteMessage", "", "message", "Lcom/example/kindergardenmanager/data/model/Message;", "(Lcom/example/kindergardenmanager/data/model/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageById", "messageId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessagesForUser", "Landroidx/lifecycle/LiveData;", "", "userId", "insertMessage", "markMessageAsRead", "updateMessage", "app_debug"})
public abstract interface MessageDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 3)
    public abstract java.lang.Object insertMessage(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Message message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateMessage(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Message message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteMessage(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.model.Message message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM messages WHERE recipientId = :userId ORDER BY timestamp DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Message>> getMessagesForUser(long userId);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM messages WHERE messageId = :messageId")
    public abstract java.lang.Object getMessageById(long messageId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Message> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "UPDATE messages SET isRead = 1 WHERE messageId = :messageId")
    public abstract java.lang.Object markMessageAsRead(long messageId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}