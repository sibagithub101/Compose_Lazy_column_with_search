package com.siba.myapplication.util

import android.os.Build
import androidx.annotation.RequiresApi
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.time.ZoneId
import java.util.TimeZone

@RunWith(MockitoJUnitRunner::class)
class UtilsTest {

    @Test
    fun `convertDateTimeFormat should return correct formatted date time`() {

        // Mock system default time zone to UTC for consistent behavior
        val systemDefaultZoneId = ZoneId.of("UTC")
        TimeZone.setDefault(TimeZone.getTimeZone(systemDefaultZoneId))

        // Timestamp in UTC
        val timestamp = "2023-03-06T10:15:30Z"

        // Expected formatted date time in system default time zone
        val expectedFormattedDateTime = "06/03/2023 10:15 AM"

        // Call the function being tested
        val actualFormattedDateTime = Utils.convertDateTImeFormat(timestamp)

        // Assert the result
        assertEquals(expectedFormattedDateTime, actualFormattedDateTime)
    }
}
