package com.example.moviesapp.profile_feature.presentation.screens.profileScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.R
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage

@Composable
fun ProfileScreen(){
   ProfileScreenContent()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileScreenContent() {
   Scaffold(
      topBar = {
         TopAppBar(
            title = { Text("Profile") },

            )
      }) {
      Column(
         modifier = Modifier
            .fillMaxSize() ,
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         CoilImage(
            imageUrl = "https://www.treehugger.com/thmb/nSp8ESJ1N6zq_bsTVL_MoSrKAqA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1273584292-cbcd5f85f4c646d58f7a7fa158dcaaeb.jpg",
            modifier = Modifier.size(150.dp)
               .clip(RoundedCornerShape(50))
         )
         Spacer(modifier = Modifier.height(5.dp))
         Text(
            text = "name", fontSize = 25.sp, fontWeight = FontWeight.Bold
         )
         Spacer(
            modifier = Modifier
               .fillMaxWidth()
               .height(60.dp)
         )
         Box(
            modifier = Modifier
               .padding(horizontal = 20.dp)
               .fillMaxWidth()
         ) {
            Column(
               modifier = Modifier
                  .padding(10.dp),
               horizontalAlignment = Alignment.Start,
               verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
               Row(
                  horizontalArrangement = Arrangement.Center,
                  modifier = Modifier.clickable {  }
               ) {
                  Icon(
                     imageVector = Icons.Default.Star ,
                     contentDescription = "",
                     tint = colorResource(id = R.color.white)
                  )
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                     text = "Watch History", fontSize = 15.sp
                  )
               }
               Spacer(
                  modifier = Modifier
                     .height(1.dp)
                     .fillMaxWidth()
                     .background(color = colorResource(id = R.color.red))
               )
               Row(
                  horizontalArrangement = Arrangement.Center,
                  modifier = Modifier.clickable { }
               ) {
                  Icon(
                     imageVector = Icons.Default.Star ,
                     contentDescription = "",
                  )
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                     text = "My Rating", fontSize = 15.sp
                  )
               }
               Spacer(
                  modifier = Modifier
                     .height(1.dp)
                     .fillMaxWidth()
                     .background(color = colorResource(id = R.color.red))
               )
               Row(
                  horizontalArrangement = Arrangement.Center
               ) {
                  Icon(
                     imageVector = Icons.Default.Lock ,
                     contentDescription = ""
                  )
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                     text = "Sign Out", fontSize = 15.sp)
               }
            }
         }
      }
   }
}
