package com.example.kindergardenmanager.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u000b2\u0006\u0010\r\u001a\u00020\bJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/kindergardenmanager/data/repository/MessageRepository;", "", "messageDao", "Lcom/example/kindergardenmanager/data/dao/MessageDao;", "(Lcom/example/kindergardenmanager/data/dao/MessageDao;)V", "getMessageById", "Lcom/example/kindergardenmanager/data/model/Message;", "messageId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessagesForUser", "Landroidx/lifecycle/LiveData;", "", "userId", "markMessageAsRead", "", "app_debug"})
public final class MessageRepository {
    private final com.example.kindergardenmanager.data.dao.MessageDao messageDao = null;
    
    public MessageRepository(@org.jetbrains.annotations.NotNull
    com.example.kindergardenmanager.data.dao.MessageDao messageDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.kindergardenmanager.data.model.Message>> getMessagesForUser(long userId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object markMessageAsRead(long messageId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMessageById(long messageId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.kindergardenmanager.data.model.Message> continuation) {
        return null;
    }
}