package com.siba.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import com.google.accompanist.pager.HorizontalPager
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.siba.myapplication.ui.NewsViewModel
import com.siba.myapplication.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainTabLayoutContent(newsViewModel: NewsViewModel,navController: NavController) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        val list = listOf(
            TabItem.Business(newsViewModel,navController),
            TabItem.Entertainment(newsViewModel,navController),
            TabItem.General(newsViewModel,navController),
            TabItem.Health(newsViewModel,navController),
            TabItem.Science(newsViewModel,navController),
            TabItem.Technology(newsViewModel,navController),
            TabItem.Sports(newsViewModel,navController)

        )

/*        DisposableEffect(newsViewModel.selectedFilterItem.value) {
            val index = list.indexOfFirst { it.title.equals(newsViewModel.selectedFilterItem.value, ignoreCase = true) }
            if (index != -1) {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }
            onDispose { }
        }*/


        funTabLayout(list,pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun funTabLayout(
    tabs: List<TabItem>,
    pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.wrapContentSize()) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = PrimaryRedColor,
            indicator =  { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            },
            contentColor = WhiteColor
        ) {
            tabs.forEachIndexed { index, tabItem ->
                LeadingIconTab(selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = tabItem.title,
                            color = Color.White
                        )
                    },
                    icon = {}
                )
            }
        }
        HorizontalPager(count = tabs.size, state = pagerState, userScrollEnabled = false) { page ->
            tabs[page].screen()
        }

    }
}