package com.siba.myapplication.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.siba.myapplication.data.local.entity.ArticlesTable
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    /**
     * Inserts a new article data into the database. If the data already exists, it will be replaced.
     * @param articlesTable The article data to be inserted or replaced.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsData(articlesTable: ArticlesTable)

    /**
     * Updates an existing article data in the database. If the data does not exist, it will be inserted.
     * @param articlesTable The updated article data.
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNewData(articlesTable: ArticlesTable)
    /**
     * Deletes the specified article data from the database.
     * @param articlesTable The article data to be deleted.
     */
    @Delete
    suspend fun deleteNewData(articlesTable: ArticlesTable)
    /**
     * Retrieves all article data from the database.
     * @return A Flow emitting a list of all article data in the database.
     */
    @Query("SELECT * FROM ArticlesTable")
    fun getAllDataFromTable(): Flow<List<ArticlesTable>>
}