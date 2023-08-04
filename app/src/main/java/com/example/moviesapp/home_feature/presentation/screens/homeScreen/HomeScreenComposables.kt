package com.example.moviesapp.home_feature.presentation.screens.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.moviesapp.R
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.TvShow

@Composable
fun HeaderHomeScreen(popularMovieList : List<Movie>) {
   LazyRow (
      contentPadding = PaddingValues(16.dp) ,
      horizontalArrangement = Arrangement.spacedBy(16.dp)
           ){
     items(popularMovieList){
        HeaderMovieItem(
           movieName = it.movieName,
           movieRate = it.rate ,
           movieCategory = "adventure,action" ,
           imageUrl = it.image
        )
     }
   }
}

@Composable
fun HeaderMovieItem(
   movieName : String ,
   movieRate : String ,
   movieCategory : String ,
   imageUrl : String
) {
   Box(contentAlignment = Alignment.BottomStart) {
      CoilImage(imageUrl = imageUrl , modifier = Modifier
         .width(300.dp)
         .height(200.dp)
         .clip(RoundedCornerShape(10.dp)))
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
         horizontalAlignment = Alignment.Start
      ) {
         Row {
            Text(text = movieName, fontSize = 15.sp)
            Icon(imageVector = Icons.Default.Star , contentDescription = null, tint = Color.Yellow)
            Text(text = movieRate, fontSize = 15.sp)
         }
         Text(text = movieCategory)
      }
   }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenBody(
   airingTodayTvShowList : List<TvShow> ,
   onTheAirTvShowList : List<TvShow> ,
   trendingTvShowList : List<TvShow> ,
   nowStreamingMovieList : List<Movie> ,
   upComingMovieList : List<Movie> ,
   topRatedMovieList : List<Movie> ,
   seeMoreClick : () -> Unit ,
   onItemClick : () -> Unit
) {
   LazyColumn {
      stickyHeader {
         MovieStickyHeader(stickyHeaderTitle = "Airing Today Tv Shows") {
            seeMoreClick()
         }
      }
      item {
         LazyRow(
            contentPadding = PaddingValues(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
            items(airingTodayTvShowList) {
               MovieItem(modifier = Modifier
                  .height(150.dp)
                  .width(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it.image
               ) { onItemClick() }
            }
         }
      }
      stickyHeader {
         MovieStickyHeader(stickyHeaderTitle = "On The Air Tv Shows") {
            seeMoreClick()
         }
      }
      item {
         LazyRow(
            contentPadding = PaddingValues(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
            items(onTheAirTvShowList) {
               MovieItem(modifier = Modifier
                  .height(150.dp)
                  .width(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it.image
               ) { onItemClick() }
            }
         }
      }
      stickyHeader {
         MovieStickyHeader(stickyHeaderTitle = "Trending Tv Shows") {
            seeMoreClick()
         }
      }
      item {
         LazyRow(
            contentPadding = PaddingValues(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
            items(trendingTvShowList) {
               MovieItem(modifier = Modifier
                  .height(150.dp)
                  .width(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it.image
               ) { onItemClick() }
            }
         }
      }
      stickyHeader {
         MovieStickyHeader(stickyHeaderTitle = "Now Streaming Movies") {
            seeMoreClick()
         }
      }
      item {
         LazyRow(
            contentPadding = PaddingValues(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
            items(nowStreamingMovieList) {
               MovieItem(modifier = Modifier
                  .height(150.dp)
                  .width(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it.image
               ) { onItemClick() }
            }
         }
      }
      stickyHeader {
         MovieStickyHeader(stickyHeaderTitle = "Up Coming Movies") {
            seeMoreClick()
         }
      }
      item {
         LazyRow(
            contentPadding = PaddingValues(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
            items(upComingMovieList) {
               MovieItem(modifier = Modifier
                  .height(150.dp)
                  .width(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it.image
               ) { onItemClick() }
            }
         }
      }
      stickyHeader {
         MovieStickyHeader(stickyHeaderTitle = "Top Rated Movies") {
            seeMoreClick()
         }
      }
      item {
         LazyRow(
            contentPadding = PaddingValues(16.dp) ,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
            items(topRatedMovieList) {
               MovieItem(modifier = Modifier
                  .height(150.dp)
                  .width(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it.image
               ) { onItemClick() }
            }
         }
      }
   }
}

@Composable
fun MovieStickyHeader(stickyHeaderTitle : String , onSeeMoreMovieClick : () -> Unit) {
   Row(
      modifier = Modifier.fillMaxWidth() ,
      horizontalArrangement = Arrangement.SpaceBetween ,
      verticalAlignment = Alignment.CenterVertically
   ) {
      Text(text = stickyHeaderTitle)
      TextButton(onClick = { onSeeMoreMovieClick() }) {
         Text(text = "see all", color = colorResource(id = R.color.red))
      }
   }
}

@Composable
fun MovieItem(modifier : Modifier = Modifier , imageUrl : String , onItemClick : () -> Unit) {
   CoilImage(imageUrl = imageUrl , modifier = modifier.clickable { onItemClick() })
}

@Composable
fun CoilImage(modifier : Modifier = Modifier , imageUrl : String) {
   SubcomposeAsyncImage(
      model = imageUrl ,
      contentScale = ContentScale.Crop ,
      contentDescription = "movie image" ,
      modifier = modifier
   )
}

@Preview
@Composable
fun Preview() {

}