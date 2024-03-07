package com.siba.myapplication.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.ui.screens.HomePage
import com.siba.myapplication.ui.screens.OfflineScreen
import com.siba.myapplication.ui.screens.WebViewScreen

@Composable
fun SetupRootNavGraph(
    rootNavController: NavHostController,
    newsViewModel: NewsViewModel,
    screenName: Screens

) {
    NavHost(
        navController = rootNavController,
        startDestination = screenName.route
    ) {

        composable(route = Screens.HomeScreen.route) {
            HomePage(navController = rootNavController, viewModel = newsViewModel)
        }
        composable(route = Screens.NewSDetailsScreen.route) {
            WebViewScreen(navController = rootNavController, viewModel = newsViewModel)
        }
        composable(route = Screens.OfflineNewsScreen.route) {
            OfflineScreen(newsViewModel = newsViewModel)
        }

    }
}

sealed class Screens(val route: String) {
    object HomeScreen : Screens("HomeScreen")
    object NewSDetailsScreen : Screens("NewsDetailsScreen")
    object OfflineNewsScreen : Screens("SaveNewsScreen")


}