package com.siba.myapplication.data.remote.repository

import NetworkResults
import com.siba.myapplication.data.remote.model.NewResponseModel
import com.siba.myapplication.data.remote.ApiService
import com.siba.myapplication.data.remote.NetworkConstant.Companion.API_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {
    /**
     * Fetches news data from the network based on the provided query string.
     *
     * @param query The query string used to filter the news data.
     * @return A Flow emitting NetworkResults, representing the loading status and the fetched news data.
     */
    suspend fun filterNews(query: String): Flow<NetworkResults<NewResponseModel>> = flow {
        emit(NetworkResults.Loading(true))
        try {
            val response = apiService.filterNews(query,API_KEY)
            emit(NetworkResults.Loading(false))
            emit(NetworkResults.Success(response))
        } catch (e: Exception) {
            emit(NetworkResults.Loading(false))
            emit(NetworkResults.Error(e.localizedMessage))
        }
    }
}
