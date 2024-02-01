package com.siba.myapplication.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.siba.myapplication.ui.DrinksViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CustomTopBar(
    viewModel: DrinksViewModel,
    searchIconClicked: MutableState<Boolean>,
) {
    var debounceJob by remember { mutableStateOf<Job?>(null) }
    val focusRequester = remember { FocusRequester() }
    val inputService = LocalTextInputService.current
    LaunchedEffect(key1 = searchIconClicked.value) {
        if (searchIconClicked.value) {
            delay(1000)
            inputService?.showSoftwareKeyboard()
            focusRequester.requestFocus()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                if (searchIconClicked.value) Color.White else Color.White
            ),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AnimatedVisibility(
                visible = searchIconClicked.value,
                enter = expandHorizontally(
                    animationSpec = tween(
                        500,
                        delayMillis = 200
                    )
                )
            ) {
                OutlinedTextField(
                    value = viewModel.strSearchDrink.value, onValueChange = {
                        if(it.isNotEmpty()) {
                            viewModel.strSearchDrink.value = it
                            debounceJob?.cancel()
                            debounceJob = CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                viewModel.searchCocktail(viewModel.strSearchDrink.value)
                            }
                        }else{
                            viewModel.searchCocktail("Rum")
                        }
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            viewModel.searchCocktail(viewModel.strSearchDrink.value)
                        }
                    ),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    placeholder = {
                        Text(
                            text = "Search Your Drink",
                            color = Color.Black
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedTextColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    maxLines = 1,
                    trailingIcon = {
                        IconButton(onClick = {
                            if (viewModel.strSearchDrink.value.isEmpty()) {
                                searchIconClicked.value = false
                            } else {
                                viewModel.strSearchDrink.value = ""
                                viewModel.searchCocktail("Rum")
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    },
                    leadingIcon = {
                        IconButton(onClick = {
                            searchIconClicked.value = false
                            viewModel.strSearchDrink.value = ""
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }
                )
            }
            AnimatedVisibility(
                visible = !searchIconClicked.value
            ) {
                IconButton(onClick = {
                    searchIconClicked.value = !searchIconClicked.value
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}