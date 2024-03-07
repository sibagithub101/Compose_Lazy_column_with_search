package com.siba.myapplication.di

import com.siba.myapplication.data.remote.ApiService
import com.siba.myapplication.data.remote.NetworkConstant.Companion.BASE_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /**
     * Provides an instance of OkHttpClient for making HTTP requests.
     *
     * @return An instance of OkHttpClient.
     */

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        })
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        //  logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        // add logging as last interceptor
        httpClient.addInterceptor(logging) // <-- this is the important line!
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.callTimeout(60, TimeUnit.SECONDS)
        httpClient.retryOnConnectionFailure(true)
        return httpClient.build()
    }

    /**
     * Provides an instance of Retrofit for defining HTTP client and BASE API .
     *
     * @param client The OkHttpClient instance to be used with Retrofit.
     * @return An instance of Retrofit.
     */
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    /**
     * Provides an instance of the ApiService interface for making network requests.
     *
     * @param retrofit The Retrofit instance used to create the ApiService.
     * @return An instance of the ApiService interface.
     */

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}