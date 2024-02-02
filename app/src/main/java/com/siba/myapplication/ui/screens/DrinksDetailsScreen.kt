package com.siba.myapplication.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.siba.myapplication.R
import com.siba.myapplication.data.model.DrinksItem
import com.siba.myapplication.ui.DrinksViewModel
import com.siba.myapplication.ui.components.onImageLoadSuccess

@Composable
fun DrinksDetailsPage(navController: NavController, viewModel: DrinksViewModel) {
    val drinkData = viewModel.drinksItem.value
    BackHandler(enabled = true) {
        navController.popBackStack("HomeScreen", inclusive = false, saveState = true)
    }
    val dominantColor: MutableState<Color> = remember {
        mutableStateOf(Color.Transparent)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(dominantColor.value)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = drinkData.strDrink ?: "N/A",
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Start
            )
        }
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(250.dp)
        ) {
            // Display the drink image
            drinkData.strDrinkThumb.let { imageUrl ->

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                            placeholder(R.drawable.progress_animation)
                            listener { request, result ->
                                onImageLoadSuccess(result, dominantColor)
                            }
                        }).build()
                )

                Image(
                    painter = painter,
                    contentDescription = "drinksImage",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(3.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier.padding(10.dp)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                // Display the drink name
                CustomItemRow("Drinks Name", drinkData.strDrink ?: "N/A")
                CustomItemRow("Ingredients", getIngredients(drinkData))
                CustomItemRow("Category", drinkData.strCategory ?: "N/A")
                CustomItemRow("Measure", getMeasure(drinkData))
                Text(
                    text = drinkData.strInstructionsIT ?: "",
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

fun getMeasure(drinkData: DrinksItem): String {
    val ingList = arrayListOf<String>()
    addItemInList(drinkData.strMeasure1, ingList)
    addItemInList(drinkData.strMeasure2, ingList)
    addItemInList(drinkData.strMeasure3, ingList)
    addItemInList(drinkData.strMeasure4, ingList)
    addItemInList(drinkData.strMeasure5, ingList)
    addItemInList(drinkData.strMeasure6, ingList)
    addItemInList(drinkData.strMeasure7, ingList)
    addItemInList(drinkData.strMeasure8, ingList)
    addItemInList(drinkData.strMeasure9, ingList)
    addItemInList(drinkData.strMeasure10, ingList)
    addItemInList(drinkData.strMeasure11, ingList)
    addItemInList(drinkData.strMeasure12, ingList)
    addItemInList(drinkData.strMeasure13, ingList)
    addItemInList(drinkData.strMeasure14, ingList)
    addItemInList(drinkData.strMeasure15, ingList)
    return ingList.joinToString(", ")
}

fun getIngredients(drinkData: DrinksItem): String {
    val ingList = arrayListOf<String>()
    addItemInList(drinkData.strIngredient1, ingList)
    addItemInList(drinkData.strIngredient2, ingList)
    addItemInList(drinkData.strIngredient3, ingList)
    addItemInList(drinkData.strIngredient4, ingList)
    addItemInList(drinkData.strIngredient5, ingList)
    addItemInList(drinkData.strIngredient6, ingList)
    addItemInList(drinkData.strIngredient7, ingList)
    addItemInList(drinkData.strIngredient8, ingList)
    addItemInList(drinkData.strIngredient9, ingList)
    addItemInList(drinkData.strIngredient10, ingList)
    addItemInList(drinkData.strIngredient11, ingList)
    addItemInList(drinkData.strIngredient12, ingList)
    addItemInList(drinkData.strIngredient13, ingList)
    addItemInList(drinkData.strIngredient14, ingList)
    addItemInList(drinkData.strIngredient15, ingList)
    return ingList.joinToString(", ")
}

private fun addItemInList(
    ingredient: String?,
    ingList: ArrayList<String>
) {
    if (!ingredient.isNullOrEmpty()) {
        ingList.add(ingredient)
    }
}

@Composable
fun CustomItemRow(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
    ) {
        Text(
            text = key,
            fontWeight = FontWeight.Medium
        )
        Text(text = " : ")
        Text(text = value)
    }
    Spacer(modifier = Modifier.height(5.dp))
}