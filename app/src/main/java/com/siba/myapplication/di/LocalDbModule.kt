package com.siba.myapplication.di

import android.content.Context
import androidx.room.Room
import com.siba.myapplication.data.local.dao.NewsDao
import com.siba.myapplication.roomdb.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module responsible for providing instances of the local database components using Hilt.
 */
@Module
@InstallIn(SingletonComponent::class)
object LocalDbModule {

    /**
     * Provides an instance of the NewsDatabase using the application context.
     *
     * @param context The application context.
     * @return An instance of the NewsDatabase.
     */

    @Provides
    @Singleton
    fun providesUserDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, "RoomDatabase")
            .fallbackToDestructiveMigration().allowMainThreadQueries()
            .build()
    }

    /**
     * Provides an instance of the NewsDao using the provided NewsDatabase instance.
     *
     * @param database The NewsDatabase instance.
     * @return An instance of the NewsDao.
     */

    @Provides
    @Singleton
    fun providesNewsDao(database: NewsDatabase): NewsDao {
        return database.newsDao()
    }
}
