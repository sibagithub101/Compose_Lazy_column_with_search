package com.siba.myapplication.data.local.repository


import com.siba.myapplication.data.local.dao.NewsDao
import com.siba.myapplication.data.local.entity.ArticlesTable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalNewsRepository @Inject constructor(private val newsDao: NewsDao) {
    suspend fun insertNews(articlesTable: ArticlesTable){
        newsDao.insertNewsData(articlesTable)
    }

      fun getAllDataFromDb():Flow<List<ArticlesTable>>{
       return newsDao.getAllDataFromTable()
    }

     suspend fun updateNews(articlesTable: ArticlesTable){
        newsDao.updateNewData(articlesTable)
    }

     suspend fun deleteNews(articlesTable: ArticlesTable){
        newsDao.deleteNewData(articlesTable)
    }


}
