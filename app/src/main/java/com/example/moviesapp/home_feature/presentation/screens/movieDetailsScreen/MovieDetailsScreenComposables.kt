package com.example.moviesapp.home_feature.presentation.screens.movieDetailsScreen

import android.util.Log
import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage

@Composable
fun HeaderMovieDetails() {
   Box(contentAlignment = Alignment.BottomCenter) {
      CoilImage(
         imageUrl = "https://www.treehugger.com/thmb/nSp8ESJ1N6zq_bsTVL_MoSrKAqA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1273584292-cbcd5f85f4c646d58f7a7fa158dcaaeb.jpg" ,
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
               Text(text = "Play Trailler")
            }
         }
      }
   }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MovieDetailsBody(
   castList : List<String>,
   reviewList : List<String>
){
   Column (horizontalAlignment = Alignment.CenterHorizontally){
      Text(text = "Avater: The Way of water")
      Row {
         Text(text ="14/12/2022 /")
         Text(text ="3h12m")
      }
      Text(text ="Science Fiction,Adventure,Action")
      Row {
         Icon(imageVector = Icons.Default.Star , contentDescription = null)
         Text(text ="7.7")
         Text(text = "(1920reviews)")
      }
      Text(text = "Overview",
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Start)
      Text(text = "the content of the overview fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
      Text(text = "Cast",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
        items(castList){
           CastItem(imageUrl = it , castName = "hi")
        }
      }
      Text(text = "Similar Movies",
         modifier = Modifier.fillMaxWidth(),
         textAlign = TextAlign.Start)
      LazyRow(
         contentPadding = PaddingValues(16.dp) ,
         horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
       items(reviewList){
          CoilImage(imageUrl = it
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
      LazyRow{
         items(reviewList){
            ReviewItem()
         }
      }
   }
}

@Composable
fun CastItem(imageUrl : String,castName : String){
   Column (verticalArrangement = Arrangement.Center,
   horizontalAlignment = Alignment.CenterHorizontally){
      CoilImage(imageUrl = imageUrl, modifier = Modifier
         .clip(RoundedCornerShape(50))
         .height(100.dp)
         .width(100.dp))
      Text(text = castName)
   }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ReviewItem(){
   Column {
      Row(
         horizontalArrangement = Arrangement.spacedBy(5.dp),
         modifier = Modifier.fillMaxWidth()
      ) {
      CoilImage(imageUrl = "")
         Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "user name")
            Text(text = "the auther", fontSize = 10.sp, color = Color.Gray)
         }
      }
      Text(text = "review content", maxLines = 5)
      Box(modifier = Modifier
         .fillMaxWidth()
         .align(Alignment.Start)
         .height(50.dp)) {
         RatingBar(rating = 5, isSelectable = false)
      }
      Spacer(modifier = Modifier
         .height(5.dp)
         .clip(RoundedCornerShape(50))
         .fillMaxWidth()
         .background(colorResource(id = R.color.red)))
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
@Preview
@Composable
fun Preview() {
   HeaderMovieDetails()
}