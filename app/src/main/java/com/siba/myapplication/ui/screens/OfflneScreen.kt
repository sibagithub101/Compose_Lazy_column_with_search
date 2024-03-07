package com.siba.myapplication.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.ui.components.CustomTopBar
import com.siba.myapplication.ui.components.NoDataFound

@Composable
fun OfflineScreen(newsViewModel:NewsViewModel) {
    Scaffold(
        containerColor = Color.White, topBar = {
            CustomTopBar( title = "Favorite News"){}
        }) {

        Box(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding()
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LaunchedEffect(key1 = true) {
                    newsViewModel.getAllData()
                }

                if(newsViewModel.newsTableList.value.isNotEmpty()){
                    LazyColumn{
                        items(newsViewModel.newsTableList.value.size){index->
                            LocalSaveItemCard(newsViewModel.newsTableList.value[index])
                        }
                    }
                }else{
                  NoDataFound()
                }
            }

        }
    }
}
