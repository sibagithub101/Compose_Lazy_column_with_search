package com.siba.myapplication.data.remote

import com.siba.myapplication.data.model.DrinksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search.php")
    suspend fun searchDrinks(@Query("s") query: String): DrinksResponse

}
