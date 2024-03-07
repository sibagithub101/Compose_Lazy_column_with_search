package com.siba.myapplication.di;

import java.lang.System;

/**
 * Module responsible for providing instances of the local database components using Hilt.
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/siba/myapplication/di/LocalDbModule;", "", "()V", "providesNewsDao", "Lcom/siba/myapplication/data/local/dao/NewsDao;", "database", "Lcom/siba/myapplication/roomdb/NewsDatabase;", "providesUserDatabase", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module
public final class LocalDbModule {
    @org.jetbrains.annotations.NotNull
    public static final com.siba.myapplication.di.LocalDbModule INSTANCE = null;
    
    private LocalDbModule() {
        super();
    }
    
    /**
     * Provides an instance of the NewsDatabase using the application context.
     *
     * @param context The application context.
     * @return An instance of the NewsDatabase.
     */
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.siba.myapplication.roomdb.NewsDatabase providesUserDatabase(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    /**
     * Provides an instance of the NewsDao using the provided NewsDatabase instance.
     *
     * @param database The NewsDatabase instance.
     * @return An instance of the NewsDao.
     */
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.siba.myapplication.data.local.dao.NewsDao providesNewsDao(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.roomdb.NewsDatabase database) {
        return null;
    }
}