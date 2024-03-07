package com.siba.myapplication.data.local.entity

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "ArticlesTable")
data class ArticlesTable(
    @PrimaryKey(autoGenerate = false)
    @NotNull
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String = "",

    @ColumnInfo(name = "author")
    val author: String? = "",

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = "",

    @ColumnInfo(name = "description")
    val description: String? = "",

    @ColumnInfo(name = "title")
    val title: String? = "",

    @ColumnInfo(name = "url")
    val url: String? = "",

    @ColumnInfo(name = "content")
    val content: String? = ""
)
