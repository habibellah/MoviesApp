package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import android.util.Log
import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
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
import com.example.moviesapp.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.home_feature.domain.model.Actor
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.Review
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage

@Composable
fun HeaderMovieDetails(imageUrl : String) {
   Box(contentAlignment = Alignment.BottomCenter) {
      CoilImage(
         imageUrl = imageUrl ,
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
      )
      Column (
         modifier = Modifier
            .fillMaxWidth()
            .height(450.dp),
         verticalArrangement = Arrangement.SpaceBetween,
         horizontalAlignment = Alignment.CenterHorizontally
              ){
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
               Text(text = "Play Trailer")
            }
         }
      }
   }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MovieDetailsBody(
   movieName : String ,
   releaseDate : String ,
   duration : String ,
   categories : String ,
   rate : String ,
   reviewCount : String ,
   overView : String ,
   actorList : List<Actor> ,
   similarMovieList : List<Movie> ,
   reviewList : List<Review>
){
   Column (horizontalAlignment = Alignment.CenterHorizontally){
      Text(text = movieName)
      Row {
         Text(text =releaseDate)
         Text(text = duration)
      }
      Text(text = categories)
      Row {
         Icon(imageVector = Icons.Default.Star , contentDescription = null)
         Text(text = rate)
         Text(text = "(${reviewCount} reviews)")
      }
      Text(text = "Overview",
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Start)
      Text(text = overView)
      Text(text = "Cast",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
        items(actorList){
           ActorItem(imageUrl = it.image , castName = it.name)
        }
      }
      Text(text = "Similar Movies",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
       items(similarMovieList){
          CoilImage(imageUrl = it.image
             , modifier = Modifier
                .height(200.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp)))

       }
      }
      Text(text = "Rate The Movie",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      RatingBar(rating = 5 , isSelectable = false)
      Text(text = "Reviews",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp),
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
         items(reviewList){
            ReviewItem(reviewContent = it.reviewContent , author = it.reviewerName , date = it.date)
         }
      }
   }
}

@Composable
fun ActorItem(imageUrl : String , castName : String){
   Column (verticalArrangement = Arrangement.Center,
   horizontalAlignment = Alignment.CenterHorizontally){
      CoilImage(imageUrl = imageUrl, modifier = Modifier
         .clip(RoundedCornerShape(50))
         .height(100.dp)
         .width(100.dp))
      Text(text = castName)
   }
}

@Composable
fun ReviewItem(reviewContent : String , author : String , date : String){
   Column(modifier = Modifier.width(200.dp)) {
      Row(
         horizontalArrangement = Arrangement.spacedBy(5.dp),
         modifier = Modifier.fillMaxWidth()
      ) {
         Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = author)
            Text(text = date, fontSize = 10.sp, color = Color.Gray)
         }
      }
      Text(text = reviewContent, maxLines = 5)
      Spacer(modifier = Modifier
         .height(5.dp)
         .clip(RoundedCornerShape(50))
         .fillMaxWidth())
      }
}

@ExperimentalComposeUiApi
@Composable
fun RatingBar(
   modifier: Modifier = Modifier,
   rating: Int,
   isSelectable : Boolean
) {
   var ratingState by remember {
      mutableStateOf(rating)
   }

   var selected by remember {
      mutableStateOf(false)
   }
   val size by animateDpAsState(
      targetValue = if (selected) 50.dp else 40.dp,
      spring(Spring.DampingRatioMediumBouncy)
   )

   Row(
      modifier = Modifier.fillMaxSize(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
   ) {
      for (i in 1..5) {
         Icon(
            imageVector = Icons.Default.Star ,
            contentDescription = "star",
            modifier = modifier
               .width(size)
               .height(size)
               .pointerInteropFilter {
                  if (isSelectable) {
                     when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                           selected = true
                           ratingState = i
                           Log.e("starNumbers" , ratingState.toString())
                        }

                        MotionEvent.ACTION_UP -> {
                           selected = false
                        }
                     }
                  }
                  true
               },
            tint = if (i <= ratingState) Color(0xFFFF0000) else Color(0xFFA2ADB1)
         )
      }
   }
}