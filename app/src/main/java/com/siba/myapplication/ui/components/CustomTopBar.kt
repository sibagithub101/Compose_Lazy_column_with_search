package com.siba.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siba.myapplication.ui.NewsViewModel

@Composable
fun CustomTopBar(
    iconShow: MutableState<Boolean> = mutableStateOf(false),
    title: String,
    onFilterItemClicked: () -> Unit = {},
    favOnclick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = TextUnit.Unspecified,
            modifier = Modifier.padding(start = 16.dp)
        )

        Row(horizontalArrangement = Arrangement.End) {
            if (iconShow.value) {
                IconButton(
                    onClick = {
                        onFilterItemClicked.invoke()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Filter"
                    )
                }

                IconButton(
                    onClick = { favOnclick.invoke() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite"
                    )
                }

            }
        }

    }
}

@Composable
fun FilterDialog(
    onFilterSelected: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .background(Color.White)
            .wrapContentSize()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(text = "Select Filter", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            val itemList = listOf(
                "Business",
                "Entertainment",
                "General",
                "Health",
                "Science",
                "Sports",
                "Technology"
            )
            itemList.forEach {
                FilterOption(it) { onFilterSelected(it.lowercase()) }
            }
        }
    }
}


@Composable
fun FilterOption(
    filterItem: String,
    onClick: () -> Unit
) {
    Text(
        text = filterItem,
        modifier = Modifier
            .clickable(onClick = { onClick() })
            .padding(10.dp)
    )
}

