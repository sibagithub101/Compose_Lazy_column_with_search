package com.siba.myapplication.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.siba.myapplication.data.local.entity.ArticlesTable
import com.siba.myapplication.data.remote.model.ArticlesItem
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetLazyColumn(navController: NavController, viewModel: NewsViewModel) {
    val context = LocalContext.current
    if (viewModel.newsArrayList.value.isNotEmpty()) {

        LazyColumn {
            items(viewModel.newsArrayList.value.size) { index ->
                val articlesItem = viewModel.newsArrayList.value[index]
                ItemArticleCard(
                    article = articlesItem,
                    onclick = { articleItem ->
                        navController.navigate("NewsDetailsScreen") {
                            viewModel.newsItem.value = articleItem
                        }
                    },
                    saveArticle = articlesItem.copyToArticlesTable(),
                    onSave = { articleTable ->
                        viewModel.insertData(articleTable)
                    }
                )
            }

        }
    } else {
        NoDataFound()
    }
}

fun ArticlesItem.copyToArticlesTable(): ArticlesTable {
    return ArticlesTable(
        publishedAt = this.publishedAt.toString(),
        author = this.author,
        urlToImage = this.urlToImage,
        description = this.description,
        title = this.title,
        url = this.url,
        content = this.content
    )
}

