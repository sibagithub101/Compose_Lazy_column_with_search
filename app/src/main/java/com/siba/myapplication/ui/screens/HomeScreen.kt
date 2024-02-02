package com.siba.myapplication.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.siba.myapplication.R
import com.siba.myapplication.ui.DrinksViewModel
import com.siba.myapplication.ui.components.CustomTopBar
import com.siba.myapplication.ui.components.SetLazyColumn
import com.siba.myapplication.ui.theme.primaryColor

@Composable
fun HomePage(navController: NavController, viewModel: DrinksViewModel) {
    val drinkState = viewModel.drinksResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        if (viewModel.drinksResponseState.value.drinksResponse == null) {
            viewModel.searchCocktail("Rum")
        }
    }

    Scaffold(
        containerColor = Color.White, topBar = {
            CustomTopBar(viewModel = viewModel, searchIconClicked = viewModel.searchIconClicked)
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
                if (drinkState.value.loading == true) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = primaryColor,
                            trackColor = ProgressIndicatorDefaults.circularTrackColor
                        )
                    }

                }
                if (drinkState.value.drinksResponse != null && drinkState.value.loading == false) {
                    //success state
                    viewModel.drinksArrayList.value = drinkState.value.drinksResponse?.drinks ?: emptyList()
                    if(!viewModel.drinksArrayList.value.isEmpty()) {
                        Text(
                            text = "Let's drink \nquality cocktails.",
                            fontStyle = FontStyle.Italic,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                        )
                    }
                    SetLazyColumn(navController, viewModel)
                }
                if(viewModel.drinksArrayList.value.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            AsyncImage(
                                model = R.drawable.nodatafound, contentDescription = "",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .align(alignment = Alignment.CenterHorizontally),
                                contentScale = ContentScale.FillBounds,
                            )
                            Text(text = "No Drinks Found!",
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp,
                                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                                )
                        }
                    }
                }
            }

        }
    }
}



