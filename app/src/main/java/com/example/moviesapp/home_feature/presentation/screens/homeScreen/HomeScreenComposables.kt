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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.moviesapp.R
import com.example.moviesapp.home_feature.domain.model.Movie

@Composable
fun HeaderHomeScreen(popularMovieList : List<Movie>) {
   LazyRow (
      contentPadding = PaddingValues(16.dp) ,
      horizontalArrangement = Arrangement.spacedBy(16.dp)
           ){
     items(popularMovieList){
        HeaderMovieItem(
           movieName = it.movieName,
           movieRate = 7 ,
           movieCategory = "adventure,action" ,
           imageUrl = it.image
        )
     }
   }
}

@Composable
fun HeaderMovieItem(
   movieName : String ,
   movieRate : Int ,
   movieCategory : String ,
   imageUrl : String
) {
   Box(contentAlignment = Alignment.BottomStart) {
      CoilImage(imageUrl = imageUrl , modifier = Modifier
         .width(250.dp)
         .height(150.dp)
         .clip(RoundedCornerShape(10.dp)))
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
         horizontalAlignment = Alignment.Start
      ) {
         Row {
            Text(text = movieName)
            Icon(imageVector = Icons.Default.Star , contentDescription = null)
            Text(text = movieRate.toString())
         }
         Text(text = movieCategory)
      }
   }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenBody(
   tvShowList : List<String> ,
   onTheAirList : List<String> ,
   trendingList : List<String> ,
   nowStreamingList : List<String> ,
   upComingList : List<String> ,
   topRatedList : List<String> ,
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
            items(tvShowList) {
               MovieItem(modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it
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
            items(onTheAirList) {
               MovieItem(modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it
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
            items(trendingList) {
               MovieItem(modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it
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
            items(nowStreamingList) {
               MovieItem(modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it
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
            items(upComingList) {
               MovieItem(modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it
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
            items(topRatedList) {
               MovieItem(modifier = Modifier
                  .size(100.dp)
                  .clip(RoundedCornerShape(10.dp))
                  , imageUrl = it
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