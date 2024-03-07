package com.siba.myapplication.data.remote.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/siba/myapplication/data/remote/repository/NewsRepository;", "", "apiService", "Lcom/siba/myapplication/data/remote/ApiService;", "(Lcom/siba/myapplication/data/remote/ApiService;)V", "filterNews", "Lkotlinx/coroutines/flow/Flow;", "LNetworkResults;", "Lcom/siba/myapplication/data/remote/model/NewResponseModel;", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NewsRepository {
    private final com.siba.myapplication.data.remote.ApiService apiService = null;
    
    @javax.inject.Inject
    public NewsRepository(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.remote.ApiService apiService) {
        super();
    }
    
    /**
     * Fetches news data from the network based on the provided query string.
     *
     * @param query The query string used to filter the news data.
     * @return A Flow emitting NetworkResults, representing the loading status and the fetched news data.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object filterNews(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends NetworkResults<com.siba.myapplication.data.remote.model.NewResponseModel>>> continuation) {
        return null;
    }
}