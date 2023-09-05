package com.example.moviesapp.home_feature.presentation.screens.tvShowDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.domain.model.Season
import com.example.moviesapp.core.presentation.CoilImage
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.ActorItem
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.RatingBar
import com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen.ReviewItem

@Composable
fun HeaderTvShowDetails(imageUrl : String) {
   Box(contentAlignment = Alignment.BottomCenter) {
      CoilImage(
         imageUrl = imageUrl ,
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
      )
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp) ,
         verticalArrangement = Arrangement.SpaceBetween ,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
         ) {
            Icon(imageVector = Icons.Default.ArrowBack , contentDescription = null)
            Icon(imageVector = Icons.Default.Create , contentDescription = null)
         }
         Button(onClick = { /*TODO*/ }) {
            Row {
               Icon(imageVector = Icons.Default.PlayArrow , contentDescription = null)
               Text(text = "Play Trailler")
            }
         }
      }
   }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TvShowDetailsBody(
   seasonsList : List<Season> ,
   reviewList : List<Review> ,
   tvShowName : String ,
   releaseDate : String ,
   genres : String ,
   rate : String ,
   voteCount : String ,
   overView : String
) {
   Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = tvShowName)
      Text(text = releaseDate)
      Text(text = genres)
      Row {
         Icon(imageVector = Icons.Default.Star , contentDescription = null)
         Text(text = rate)
         Text(text = "(${voteCount} reviews)")
      }
      Text(
         text = "Overview" ,
         modifier = Modifier.fillMaxWidth() ,
         textAlign = TextAlign.Start
      )
      Text(text = overView)
      Text(
         text = "Seasons" ,
         modifier = Modifier.fillMaxWidth() ,
         textAlign = TextAlign.Start
      )
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
         items(seasonsList) {
            SeasonItem(imageUrl = it.posterPath , name = it.name , airData = it.airDate , episodeCount = it.episodeCount)
         }
      }
      Text(
         text = "Rate The Movie" ,
         modifier = Modifier.fillMaxWidth() ,
         textAlign = TextAlign.Start
      )
      RatingBar(rating = 5 , isSelectable = false)
      Text(
         text = "Reviews" ,
         modifier = Modifier.fillMaxWidth() ,
         textAlign = TextAlign.Start
      )
      LazyRow {
         items(reviewList) {
            ReviewItem(it.reviewContent , it.reviewerName , it.date)
         }
      }
   }
}

@Composable
fun SeasonItem(
   imageUrl : String , name : String , airData : String , episodeCount : Int
) {
   Row(modifier = Modifier.fillMaxWidth()) {
      CoilImage(
         imageUrl = imageUrl ,
         modifier = Modifier
            .height(200.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(10.dp))
      )
      Column(modifier = Modifier.height(200.dp) , verticalArrangement = Arrangement.SpaceAround) {
            Text(text = name)
            Text(text = airData)
            Text(text = "$episodeCount Episode")
      }
   }
}
