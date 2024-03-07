package com.siba.myapplication.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/siba/myapplication/di/NetworkModule;", "", "()V", "provideApiService", "Lcom/siba/myapplication/data/remote/ApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideRetrofit", "client", "app_debug"})
@dagger.Module
public final class NetworkModule {
    
    public NetworkModule() {
        super();
    }
    
    /**
     * Provides an instance of OkHttpClient for making HTTP requests.
     *
     * @return An instance of OkHttpClient.
     */
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    /**
     * Provides an instance of Retrofit for defining HTTP client and BASE API .
     *
     * @param client The OkHttpClient instance to be used with Retrofit.
     * @return An instance of Retrofit.
     */
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient client) {
        return null;
    }
    
    /**
     * Provides an instance of the ApiService interface for making network requests.
     *
     * @param retrofit The Retrofit instance used to create the ApiService.
     * @return An instance of the ApiService interface.
     */
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.siba.myapplication.data.remote.ApiService provideApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
}