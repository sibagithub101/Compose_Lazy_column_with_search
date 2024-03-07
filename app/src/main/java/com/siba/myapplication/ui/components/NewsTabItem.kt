package com.siba.myapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.ui.screens.*

sealed class TabItem(val title: String, val screen: @Composable () -> Unit) {
    class Business(newsViewModel: NewsViewModel,navController: NavController) :
        TabItem("Business", screen = { BusinessScreen(newsViewModel,navController) })

    class Entertainment(newsViewModel: NewsViewModel,navController: NavController) : TabItem(
        "Entertainment",
        screen = { EntertainmentScreen(newsViewModel,navController) }
    )

    class General(newsViewModel: NewsViewModel,navController: NavController) : TabItem(
        "General",
        screen = { GeneralScreen(newsViewModel,navController) }
    )

    class Health(newsViewModel: NewsViewModel,navController: NavController) : TabItem(
        "Health",
        screen = { HealthScreen(newsViewModel,navController) }
    )

    class Science(newsViewModel: NewsViewModel,navController: NavController) : TabItem(
        "Science",
        screen = { ScienceScreen(newsViewModel,navController) }
    )

    class Technology(newsViewModel: NewsViewModel,navController: NavController) : TabItem(
        "Technology",
        screen = { TechnologyScreen(newsViewModel,navController) }
    )

    class Sports(newsViewModel: NewsViewModel,navController: NavController) : TabItem(
        "Sports",
        screen = { SportsScreen(newsViewModel,navController) }
    )

}