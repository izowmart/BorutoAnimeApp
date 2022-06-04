package com.example.borutoapp.presentation.screens.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchTopBar(
                text = text,
                onTextChange = onTextChange,
                onSearchClicked = onSearchClicked,
                onCloseClicked = onCloseClicked
            )
        }
    ) {

    }

}