package com.example.borutoapp.presentation.common

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.borutoapp.R
import com.example.borutoapp.domain.model.Hero
import com.example.borutoapp.navigation.Screen
import com.example.borutoapp.presentation.components.RatingWidget
import com.example.borutoapp.ui.theme.*
import com.example.borutoapp.util.Constants.BASE_URL

@ExperimentalCoilApi
@Composable
fun ListContent(
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    Log.d("ListContent: ", heroes.loadState.toString())
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = heroes,
            key = { hero ->
                hero.id
            }
        ) { hero ->
            hero?.let {
                HeroItem(hero = it, navController = navController)
            }

        }
    }

}

@ExperimentalCoilApi
@Composable
fun HeroItem(
    hero: Hero,
    navController: NavHostController
) {
    // load image using coin library
    val painter = rememberImagePainter(data = "$BASE_URL${hero.image}") {
        placeholder(R.drawable.placeholder)
        error(R.drawable.placeholder)
    }
    Box(
        modifier = Modifier
            .height(400.dp)
            .clickable { navController.navigate(Screen.Details.passHeroId(hero.id)) },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
//            AsyncImage(
//                modifier = Modifier.fillMaxSize(),
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(data = "$BASE_URL${hero.image}")
//                    .placeholder(drawableResId = R.drawable.placeholder)
//                    .error(drawableResId = R.drawable.placeholder)
//                    .build(),
//                contentDescription = stringResource(id = R.string.hero_image),
//                contentScale = ContentScale.Crop
//            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(R.string.hero_image),
                contentScale = ContentScale.Crop
            )

        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {

                Text(
                    text = hero.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.about,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(modifier = Modifier.padding(end = 4.dp), rating = hero.rating)
                    Text(
                        text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }

        }

    }

}
