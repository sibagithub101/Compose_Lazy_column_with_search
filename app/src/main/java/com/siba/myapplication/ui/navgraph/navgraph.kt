package com.siba.myapplication.ui.navgraph


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.siba.myapplication.ui.DrinksViewModel
import com.siba.myapplication.ui.screens.DrinksDetailsPage
import com.siba.myapplication.ui.screens.HomePage

@Composable
fun SetupRootNavGraph(
    rootNavController: NavHostController,
    drinksViewModel: DrinksViewModel
) {
    NavHost(
        navController = rootNavController,
        startDestination = Screens.HomeScreen.route
    ) {

        composable(route = Screens.HomeScreen.route) {
            HomePage(navController = rootNavController, viewModel = drinksViewModel)
        }
        composable(route = Screens.DrinksDetailsScreen.route) {
            DrinksDetailsPage(navController = rootNavController, viewModel = drinksViewModel)
        }

    }
}
sealed class Screens(val route:String){
object StartScreen:Screens("SplashScreen")
object HomeScreen:Screens("HomeScreen")
object DrinksDetailsScreen:Screens("DrinksDetailsScreen")

}