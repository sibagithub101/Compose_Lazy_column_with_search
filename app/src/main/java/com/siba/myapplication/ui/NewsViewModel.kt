package com.siba.myapplication.ui

import NetworkResults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siba.myapplication.data.local.entity.ArticlesTable
import com.siba.myapplication.data.local.repository.LocalNewsRepository
import com.siba.myapplication.data.remote.model.ArticlesItem
import com.siba.myapplication.data.remote.model.NewResponseModel
import com.siba.myapplication.data.remote.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository,private val localRepository: LocalNewsRepository) : ViewModel() {

    var newsResponseState: MutableStateFlow<NewsResponseState> =
        MutableStateFlow(NewsResponseState())
        private set

    var newsItem: MutableState<ArticlesItem> = mutableStateOf(ArticlesItem())
        private set
    var selectedFilterItem: MutableState<String> = mutableStateOf("")
        private set

    var newsArrayList: MutableState<List<ArticlesItem>> = mutableStateOf(emptyList())
        private set

    var newsTableList: MutableState<List<ArticlesTable>> = mutableStateOf(emptyList())
        private set



    fun filterNews(query: String) {
        viewModelScope.launch {
            repository.filterNews(query).collect { netWorkResult ->
                when (netWorkResult) {
                    is NetworkResults.Success -> {
                        newsResponseState.emit(
                            newsResponseState.value.copy(
                                newsResponse = netWorkResult.data,
                                loading = false,
                                error = null
                            )
                        )
                    }

                    is NetworkResults.Error -> {
                        newsResponseState.emit(
                            newsResponseState.value.copy(
                                newsResponse = null,
                                loading = false,
                                error = netWorkResult.message
                            )
                        )
                    }

                    is NetworkResults.Loading -> {
                        newsResponseState.emit(
                            newsResponseState.value.copy(
                                newsResponse = null,
                                loading = netWorkResult.isLoading,
                                error = null
                            )
                        )
                    }

                    else -> {
                        // else case will be handled
                    }

                }
            }

        }
    }


    fun insertData(articlesTable: ArticlesTable){
        viewModelScope.launch {
            localRepository.insertNews(articlesTable)
        }
    }

     fun getAllData():List<ArticlesTable>{
         viewModelScope.launch {
             localRepository.getAllDataFromDb().collect{
                 newsTableList.value = it
             }
         }
     return newsTableList.value
    }
}

data class NewsResponseState(
    var newsResponse: NewResponseModel? = null,
    var loading: Boolean? = null,
    var error: String? = null
)