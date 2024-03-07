package com.siba.myapplication.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.ui.components.CustomLoader
import com.siba.myapplication.ui.components.NoDataFound
import com.siba.myapplication.ui.components.SetLazyColumn


@Composable
fun BusinessScreen(newsViewModel: NewsViewModel, navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()

    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("business")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse==null) {
        CustomLoader()

    }
  else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    }
    else {
     NoDataFound()
    }

}


@Composable
fun EntertainmentScreen(newsViewModel: NewsViewModel,navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("entertainment")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse == null) {
        CustomLoader()

    } else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    } else {
        NoDataFound()
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GeneralScreen(newsViewModel: NewsViewModel,navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("general")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse == null) {
        CustomLoader()

    } else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    } else {
        NoDataFound()
    }

}
@Composable
fun HealthScreen(newsViewModel: NewsViewModel,navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("health")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse == null) {
        CustomLoader()

    } else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    } else {
        NoDataFound()
    }

}
@Composable
fun ScienceScreen(newsViewModel: NewsViewModel,navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("science")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse == null) {
        CustomLoader()

    } else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    } else {
        NoDataFound()
    }

}
@Composable
fun TechnologyScreen(newsViewModel: NewsViewModel,navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("technology")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse == null) {
        CustomLoader()

    } else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    } else {
        NoDataFound()
    }

}
@Composable
fun SportsScreen(newsViewModel: NewsViewModel,navController: NavController) {
    val newsState = newsViewModel.newsResponseState.collectAsState()
    LaunchedEffect(key1 = true) {
        newsViewModel.filterNews("sports")
    }

    if (newsState.value.loading == true && newsState.value.newsResponse == null) {
        CustomLoader()

    } else if (newsState.value.newsResponse != null && newsState.value.loading == false) {
        //success state
        newsViewModel.newsArrayList.value = newsState.value.newsResponse?.articles ?: emptyList()
        SetLazyColumn(navController, newsViewModel)
    } else {
        NoDataFound()
    }

}
