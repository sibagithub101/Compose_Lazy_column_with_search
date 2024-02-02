package com.siba.myapplication.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.siba.myapplication.ui.DrinksViewModel

@Composable
fun SetLazyColumn(navController: NavController, viewModel: DrinksViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items(viewModel.drinksArrayList.value.size) { drink ->
            ItemFoodCard(viewModel.drinksArrayList.value[drink]) { drinksItem ->
                navController.navigate("DrinksDetailsScreen") {
                    viewModel.drinksItem.value = drinksItem
                }
            }
        }
    }
}