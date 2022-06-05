package com.example.borutoapp.presentation.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.domain.usecase.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val useCases: UseCases
) :ViewModel()  {
    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedHeroes = MutableStateFlow<PagingData<Hero>>(PagingData.empty())
    val searchedHeroes = _searchedHeroes

    fun updateSearchQuery(query: String){
        _searchQuery.value = query
    }

    fun searchHeroes(query:String){
        viewModelScope.launch(Dispatchers.IO){
            useCases.searchHeroesUseCase(query = query).cachedIn(viewModelScope).collect {
                searchedHeroes.value = it
            }

        }
    }
}