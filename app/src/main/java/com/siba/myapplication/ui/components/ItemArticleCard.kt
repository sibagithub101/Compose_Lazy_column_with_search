package com.siba.myapplication.ui.components

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import coil.request.SuccessResult
import com.google.accompanist.imageloading.rememberDrawablePainter
import com.siba.myapplication.R
import com.siba.myapplication.data.local.entity.ArticlesTable
import com.siba.myapplication.data.remote.model.ArticlesItem
import com.siba.myapplication.ui.theme.PrimaryRedColor
import com.siba.myapplication.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ItemArticleCard(article: ArticlesItem, onclick: (article: ArticlesItem) -> Unit, saveArticle: ArticlesTable, onSave: (articleTable:ArticlesTable) -> Unit) {

    val dominantColor: MutableState<Color> = remember {
        mutableStateOf(Color.Transparent)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = dominantColor.value
        ),
        modifier = Modifier
            .padding(10.dp)
    ) {
        Box(modifier = Modifier.wrapContentWidth()) {
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                            .background(Color.White)
                            .padding(4.dp).clickable {
                                                     onSave.invoke(saveArticle)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Save", color = Color.White, fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                            )
                        }
                    }
                }

                article.urlToImage?.let { imageUrl ->
                    val context= LocalContext.current
                    AsyncImage(
                        model = imageUrl, contentDescription = "",
                        modifier = Modifier.wrapContentSize()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds,
                        placeholder = rememberDrawablePainter(drawable = context.getDrawable(R.drawable.progress_animation)),
                        onSuccess = { result ->
                            onImageLoadSuccess(result.result, dominantColor)
                        }
                    )

                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = article.title.orEmpty().uppercase(Locale.ROOT),
                    style = MaterialTheme.typography.bodyMedium,
                    color = PrimaryRedColor,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = article.description.toString().lowercase(Locale.ROOT),
                    style = MaterialTheme.typography.bodyMedium,
                    color = PrimaryRedColor,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = Utils.convertDateTImeFormat(article.publishedAt.toString()),
                    style = MaterialTheme.typography.bodyMedium,
                    color = PrimaryRedColor,
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
                            .padding(4.dp).clickable {
                                onclick.invoke(article)
                            },
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