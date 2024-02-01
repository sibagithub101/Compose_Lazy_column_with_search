package com.siba.myapplication.data.repository

import NetworkResults
import com.siba.myapplication.data.model.DrinksResponse
import com.siba.myapplication.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DrinksRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun searchDrinks(query: String): Flow<NetworkResults<DrinksResponse>> = flow {
        emit(NetworkResults.Loading(true))
        try {
            val response = apiService.searchDrinks(query)
            emit(NetworkResults.Loading(false))
            emit(NetworkResults.Success(response))
        } catch (e: Exception) {
            emit(NetworkResults.Loading(false))
            emit(NetworkResults.Error(e.localizedMessage))
        }
    }
}
