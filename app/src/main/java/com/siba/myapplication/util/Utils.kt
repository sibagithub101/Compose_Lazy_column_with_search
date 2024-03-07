package com.siba.myapplication.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Base64
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone


object Utils {
    @RequiresApi(Build.VERSION_CODES.O)
    fun convertDateTImeFormat(timestamp: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val dateTime = LocalDateTime.parse(timestamp, formatter)

        // Convert to desired format
        val formatterOut = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a", Locale.ENGLISH)
        val zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC"))
            .withZoneSameInstant(ZoneId.systemDefault())
        return formatterOut.format(zonedDateTime) ?: ""
    }
}