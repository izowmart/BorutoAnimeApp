package com.example.borutoapp.presentation.screens.search

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.borutoapp.ui.theme.TOP_APP_BAR_HEIGHT
import com.example.borutoapp.ui.theme.topAppBarBackgroundColor

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

@Composable
fun SearchTopBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {

}

@Composable
fun SearchWidget(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        color =MaterialTheme.colors.topAppBarBackgroundColor,
        elevation = AppBarDefaults.TopAppBarElevation
    ) {

        TextField(value = text, onValueChange = onTextChange(text)){

        }
    }

}