package com.siba.myapplication.data.local.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/siba/myapplication/data/local/dao/NewsDao;", "", "deleteNewData", "", "articlesTable", "Lcom/siba/myapplication/data/local/entity/ArticlesTable;", "(Lcom/siba/myapplication/data/local/entity/ArticlesTable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDataFromTable", "Lkotlinx/coroutines/flow/Flow;", "", "insertNewsData", "updateNewData", "app_debug"})
public abstract interface NewsDao {
    
    /**
     * Inserts a new article data into the database. If the data already exists, it will be replaced.
     * @param articlesTable The article data to be inserted or replaced.
     */
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertNewsData(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.local.entity.ArticlesTable articlesTable, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    /**
     * Updates an existing article data in the database. If the data does not exist, it will be inserted.
     * @param articlesTable The updated article data.
     */
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update(onConflict = 1)
    public abstract java.lang.Object updateNewData(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.local.entity.ArticlesTable articlesTable, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    /**
     * Deletes the specified article data from the database.
     * @param articlesTable The article data to be deleted.
     */
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteNewData(@org.jetbrains.annotations.NotNull
    com.siba.myapplication.data.local.entity.ArticlesTable articlesTable, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    /**
     * Retrieves all article data from the database.
     * @return A Flow emitting a list of all article data in the database.
     */
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM ArticlesTable")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.siba.myapplication.data.local.entity.ArticlesTable>> getAllDataFromTable();
}