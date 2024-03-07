package com.siba.myapplication.data.remote

import com.siba.myapplication.data.remote.model.NewResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    suspend fun filterNews(@Query("q") query: String, @Query("apiKey") apiKey:String): NewResponseModel



}
