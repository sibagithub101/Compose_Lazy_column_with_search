package com.siba.myapplication.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.ui.components.CustomTopBar
import com.siba.myapplication.ui.components.FilterDialog
import com.siba.myapplication.ui.components.MainTabLayoutContent
import com.siba.myapplication.util.NetworkConnection

@Composable
fun HomePage(navController: NavController, viewModel: NewsViewModel) {
    val showFilterItems = remember {
        mutableStateOf(false)
    }
    Scaffold(
        containerColor = Color.White, topBar = {
            CustomTopBar(
                title = "Today News",
                iconShow = remember { mutableStateOf(true) },
                onFilterItemClicked = {
                    showFilterItems.value = !showFilterItems.value
                }) {
                navController.navigate("SaveNewsScreen")
            }
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
                MainTabLayoutContent(viewModel, navController)
            }

            if (showFilterItems.value) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
                    FilterDialog(
                        onFilterSelected = { filter ->
                            showFilterItems.value = false
                            viewModel.selectedFilterItem.value = filter
                            viewModel.filterNews(viewModel.selectedFilterItem.value)
                        }
                    )
                }
            }
        }
    }
}



