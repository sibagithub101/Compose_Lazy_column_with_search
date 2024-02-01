package com.siba.myapplication.ui.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.siba.myapplication.R
import com.siba.myapplication.data.model.DrinksItem
import com.siba.myapplication.ui.theme.primaryColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun ItemFoodCard(drink: DrinksItem, onclick: (drink: DrinksItem) -> Unit) {
    val width = LocalConfiguration.current
    val screenWidth = width.screenWidthDp
    val cardWidth = (screenWidth / 2) - 20
    val dominantColor: MutableState<Color> = remember {
        mutableStateOf(Color.Transparent)
    }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = dominantColor.value
        ),
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onclick.invoke(drink)
            }
    ) {
        Box(modifier = Modifier.width(cardWidth.dp)) {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                // Display the drink image
                drink.strDrinkThumb?.let { imageUrl ->
                    val painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                            .apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                                placeholder(R.drawable.progress_animation)
                                listener { _, result ->
                                    onImageLoadSuccess(result, dominantColor)
                                }
                            }).build()
                    )

                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .size(cardWidth.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                }
                // Display the drink name
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = drink.strDrink.orEmpty(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = primaryColor,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                            .background(Color.White)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "View", color = Color.White, fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

fun onImageLoadSuccess(result: SuccessResult, dominantColor: MutableState<Color>) {
    val bitmap: Bitmap? = (result as? SuccessResult)?.drawable?.toBitmap()
    val convertedBitmap = bitmap?.copy(Bitmap.Config.ARGB_8888, true)

    CoroutineScope(Dispatchers.Default).launch {
        bitmap?.let {
            dominantColor.value = getDominantColor(convertedBitmap!!)
        }
    }
}

private suspend fun getDominantColor(bitmap: Bitmap): Color {
    return withContext(Dispatchers.Default) {
        val palette = Palette.from(bitmap).generate()
        val dominantSwatch = palette.dominantSwatch
        dominantSwatch?.rgb?.let { Color(it) } ?: Color.Transparent
    }
}
