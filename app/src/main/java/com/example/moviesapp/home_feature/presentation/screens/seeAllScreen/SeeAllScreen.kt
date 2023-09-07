package com.example.moviesapp.home_feature.presentation.screens.seeAllScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesapp.core.presentation.CoilImage

@Composable
fun SeeAllScreen(
   seeAllViewModel : SeeAllViewModel = hiltViewModel()
){
   val seeAllUiState = seeAllViewModel.state.collectAsState()
   SeeAllScreenContent(
      seeAllUiState,
      seeAllViewModel
   )
}

@Composable
private fun SeeAllScreenContent(
   allMoviesState : State<SeeAllUiState> ,
   seeAllViewModel : SeeAllViewModel
) {
   LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
   contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
   ){
      items(allMoviesState.value.movieList.size){ index ->
         val item = allMoviesState.value.movieList[index]

         if (index >= allMoviesState.value.movieList.size - 1 && !allMoviesState.value.endReached && !allMoviesState.value.loading) {
            seeAllViewModel.loadNextItems()
         }
         CoilImage(imageUrl = item.image,
            modifier = Modifier
               .height(150.dp)
               .width(100.dp)
               .clip(RoundedCornerShape(10.dp)))
      }
      item {
         if (allMoviesState.value.loading) {
            Row(
               modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp),
               horizontalArrangement = Arrangement.Center
            ) {
               CircularProgressIndicator(
                  modifier = Modifier
                     .background(color = Color.White)
                     .height(100.dp)
                     .width(100.dp)
               )
            }
         }
      }
   }
}
