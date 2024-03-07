package com.siba.myapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.siba.myapplication.ui.components.CustomPopUpMessage
import com.siba.myapplication.ui.navgraph.Screens
import com.siba.myapplication.ui.navgraph.SetupRootNavGraph
import com.siba.myapplication.ui.theme.MyApplicationTheme
import com.siba.myapplication.util.NetworkConnection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var viewModel: NewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val showNetworkPopUp = remember {
                mutableStateOf(false)
            }
            val navigateToOfflineScreen = remember {
                mutableStateOf(false)
            }

            viewModel = hiltViewModel()
            val navController = rememberNavController()
            MyApplicationTheme {
                LaunchedEffect(key1 = Unit) {
                    showNetworkPopUp.value =
                        !NetworkConnection.isNetworkAvailable(applicationContext)
                }
                if (NetworkConnection.isNetworkAvailable(applicationContext)) {
                    SetupRootNavGraph(
                        rootNavController = navController,
                        newsViewModel = viewModel,
                        screenName = Screens.HomeScreen
                    )
                } else if (showNetworkPopUp.value) {
                    CustomPopUpMessage(
                        warningDesc = "You are offline go to your save News",
                        onClick = {
                            showNetworkPopUp.value = false
                            navigateToOfflineScreen.value = true
                        },
                        showNoNetworkDialog = showNetworkPopUp
                    )
                } else {
                    SetupRootNavGraph(
                        rootNavController = navController,
                        newsViewModel = viewModel,
                        screenName = Screens.OfflineNewsScreen
                    )
                }
            }
        }
    }
}
