package com.example.borutoapp.presentation.screens.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.borutoapp.presentation.common.ListContent

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
    navigation: NavHostController
) {
    val searchQueue by searchViewModel.searchQuery
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchTopBar(
                text = searchQueue,
                onTextChange = {searchViewModel.updateSearchQuery(it)},
                onSearchClicked = {
                    searchViewModel.searchHeroes(it)
                },
                onCloseClicked = {
                    navigation.popBackStack()
                }
            )
        },
        content = {
            ListContent(heroes = heroes, navController = navigation)
        }
    )

}