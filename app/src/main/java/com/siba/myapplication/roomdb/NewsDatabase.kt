package com.siba.myapplication.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.siba.myapplication.data.local.dao.NewsDao
import com.siba.myapplication.data.local.entity.ArticlesTable
/**
 * Room database class for storing news-related data.
 *
 * @param entities The array of entities associated with this database.
 * @param version The version of the database schema.
 * @param exportSchema Whether to export the schema of the database.
 */
@Database(entities = [ArticlesTable::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}