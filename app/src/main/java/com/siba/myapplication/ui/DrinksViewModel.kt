package com.siba.myapplication.ui

import NetworkResults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siba.myapplication.data.model.DrinksItem
import com.siba.myapplication.data.model.DrinksResponse
import com.siba.myapplication.data.repository.DrinksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DrinksViewModel @Inject constructor(private val repository: DrinksRepository) : ViewModel() {

    var drinksResponseState: MutableStateFlow<DrinksResponseState> =
        MutableStateFlow(DrinksResponseState())
        private set
    var searchIconClicked =
        mutableStateOf(false)
        private set

    var drinksItem: MutableState<DrinksItem> = mutableStateOf(DrinksItem())
        private set
    var strSearchDrink: MutableState<String> = mutableStateOf("")
        private set

    var drinksArrayList: MutableState<List<DrinksItem>> = mutableStateOf(emptyList())
        private set


    fun searchCocktail(query: String) {
        viewModelScope.launch {
            repository.searchDrinks(query).collect { netWorkResult ->
                when (netWorkResult) {
                    is NetworkResults.Success -> {
                        drinksResponseState.emit(
                            drinksResponseState.value.copy(
                                drinksResponse = netWorkResult.data,
                                loading = false,
                                error = null
                            )
                        )
                    }

                    is NetworkResults.Error -> {
                        drinksResponseState.emit(
                            drinksResponseState.value.copy(
                                drinksResponse = null,
                                loading = false,
                                error = netWorkResult.message
                            )
                        )
                    }

                    is NetworkResults.Loading -> {
                        drinksResponseState.emit(
                            drinksResponseState.value.copy(
                                drinksResponse = null,
                                loading = netWorkResult.isLoading,
                                error = null
                            )
                        )
                    }

                    else -> {

                    }
                }
            }

        }
    }
}

data class DrinksResponseState(
    var drinksResponse: DrinksResponse? = null,
    val loading: Boolean? = null,
    val error: String? = null
)