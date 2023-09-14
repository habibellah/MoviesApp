package com.example.moviesapp.search_feature.presentation.screens.exploreScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviesapp.R
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.core.presentation.CoilImage
import com.example.moviesapp.search_feature.domain.model.util.MediaType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderExploreScreen(onMovieButtonClick : () -> Unit , onTvShowButtonClick : () -> Unit,onGeneralSearchClick:() -> Unit) {
   Column(
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Text(text = "general search ..." , modifier =
      Modifier
         .fillMaxWidth()
         .height(40.dp)
         .clip(RoundedCornerShape(10))
         .clickable { onGeneralSearchClick() }
         .background(color = colorResource(id = com.airbnb.lottie.R.color.material_blue_grey_800)) ,
         textAlign = TextAlign.Center)
      Spacer(modifier = Modifier.height(10.dp))
      Row(
         modifier = Modifier.fillMaxWidth() ,
         horizontalArrangement = Arrangement.SpaceBetween
      ) {
         CustomSearchButton("Movies") { onMovieButtonClick() }
         CustomSearchButton("TvShows") { onTvShowButtonClick() }
      }
   }
}

@Composable
fun CustomSearchButton(searchTitle : String , onButtonClick : () -> Unit) {
   Box(
      modifier = Modifier
         .height(100.dp)
         .width(100.dp)
         .clip(RoundedCornerShape(10.dp))
         .clickable { onButtonClick() }
         .background(color = colorResource(id = R.color.black))
   ) {
      TextButton(onClick = { onButtonClick() } , modifier = Modifier.fillMaxSize()) {
         Column(
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally
         ) {
            Icon(
               imageVector = Icons.Default.Face , contentDescription = null , tint = colorResource(
                  id = R.color.red
               )
            )
            Text(text = searchTitle , color = colorResource(id = R.color.red))
         }
      }
   }
}

@Composable
fun ExploreScreenBody(trendingTodayList : List<TvShow> , onExploreMediaClick : (Int) -> Unit) {
   Column {
      Text(text = "Trending Today")
      LazyVerticalGrid(
         columns = GridCells.Fixed(2) ,
         verticalArrangement = Arrangement.spacedBy(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp) ,
         contentPadding = PaddingValues(16.dp)
      ) {
         items(trendingTodayList) {
            CoilImage(
               imageUrl = it.image ,
               modifier = Modifier
                  .clickable { onExploreMediaClick(it.tvShowId) }
                  .height(140.dp)
                  .width(80.dp)
                  .clip(
                     RoundedCornerShape(10.dp)
                  )
            )
         }
      }
   }
}