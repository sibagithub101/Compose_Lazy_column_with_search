package com.siba.myapplication.roomdb;

import java.lang.System;

/**
 * Room database class for storing news-related data.
 *
 * @param entities The array of entities associated with this database.
 * @param version The version of the database schema.
 * @param exportSchema Whether to export the schema of the database.
 */
@androidx.room.Database(entities = {com.siba.myapplication.data.local.entity.ArticlesTable.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/siba/myapplication/roomdb/NewsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "newsDao", "Lcom/siba/myapplication/data/local/dao/NewsDao;", "app_debug"})
public abstract class NewsDatabase extends androidx.room.RoomDatabase {
    
    public NewsDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.siba.myapplication.data.local.dao.NewsDao newsDao();
}