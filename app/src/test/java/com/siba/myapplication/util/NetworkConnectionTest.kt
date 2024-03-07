package com.siba.myapplication.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NetworkConnectionTest {

    @Mock
    private lateinit var mockContext:Context

    @Mock
    private lateinit var mockConnectivityManager: ConnectivityManager

    @Mock
    private lateinit var mockNetwork: Network
    @Mock
    private lateinit var mockCapabilities: NetworkCapabilities


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `isNetworkAvailable should return true when internet is available`() {
        Mockito.`when`(mockConnectivityManager.activeNetwork).thenReturn(mockNetwork)
        Mockito.`when`(mockCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)).thenReturn(true)
        Mockito.`when`(mockConnectivityManager.getNetworkCapabilities(mockNetwork)).thenReturn(mockCapabilities)
        Mockito.`when`(mockContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager)
        val result=NetworkConnection.isNetworkAvailable(mockContext)
        assertEquals(true,result)
    }

    @Test
    fun `isNetworkAvailable should return false when internet is not available`() {4
        Mockito.`when`(mockConnectivityManager.activeNetwork).thenReturn(mockNetwork)
        Mockito.`when`(mockCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)).thenReturn(false)
        Mockito.`when`(mockConnectivityManager.getNetworkCapabilities(mockNetwork)).thenReturn(mockCapabilities)
        Mockito.`when`(mockContext.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager)
        val result=NetworkConnection.isNetworkAvailable(mockContext)
        assertEquals(false,result)
    }
}