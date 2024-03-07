package com.siba.myapplication.data.remote.repository

import com.siba.myapplication.data.remote.ApiService
import com.siba.myapplication.data.remote.model.NewResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NewsRepositoryTest {
    private lateinit var mockNewsRepository: NewsRepository
    @Mock
    private lateinit var mockApiService: ApiService

    private val testDispatcher= TestCoroutineDispatcher()


    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        mockNewsRepository= NewsRepository(mockApiService)
    }

    @Test
    fun `filterNews will emit loading and success value`() = runTest {
        val mockResponse= NewResponseModel(totalResults = 8)
        Mockito.`when`(mockApiService.filterNews(anyString(), anyString())).thenReturn(mockResponse)
        mockNewsRepository.filterNews("business")
        testDispatcher.scheduler.advanceUntilIdle()
    }
}