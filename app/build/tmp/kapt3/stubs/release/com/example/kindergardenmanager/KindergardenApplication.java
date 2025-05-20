package com.example.kindergardenmanager;

import java.lang.System;

/**
 * Application class for global application state
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/example/kindergardenmanager/KindergardenApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/kindergardenmanager/data/database/KindergardenDatabase;", "getDatabase", "()Lcom/example/kindergardenmanager/data/database/KindergardenDatabase;", "database$delegate", "Lkotlin/Lazy;", "userRepository", "Lcom/example/kindergardenmanager/data/repository/UserRepository;", "getUserRepository", "()Lcom/example/kindergardenmanager/data/repository/UserRepository;", "userRepository$delegate", "app_release"})
public final class KindergardenApplication extends android.app.Application {
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy userRepository$delegate = null;
    
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
}