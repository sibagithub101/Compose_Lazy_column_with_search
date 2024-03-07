package com.siba.myapplication.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.siba.myapplication.R

@Composable
fun NoDataFound() {
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
            Text(text = "No Articles Found!",
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}