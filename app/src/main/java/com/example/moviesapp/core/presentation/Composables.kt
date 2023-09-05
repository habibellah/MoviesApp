package com.example.moviesapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.SubcomposeAsyncImage

@Composable
fun CoilImage(modifier : Modifier = Modifier , imageUrl : String) {
   SubcomposeAsyncImage(
      model = imageUrl ,
      contentScale = ContentScale.Crop ,
      contentDescription = "movie image" ,
      modifier = modifier
   )
}