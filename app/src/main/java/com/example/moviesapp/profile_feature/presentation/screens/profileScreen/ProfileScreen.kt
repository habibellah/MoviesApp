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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moviesapp.R
import com.example.moviesapp.core.presentation.CoilImage
import com.example.moviesapp.core.presentation.navigation.routes.navigateToLoginScreen

@Composable
fun ProfileScreen(
   profileViewModel : ProfileViewModel = hiltViewModel(),
   navController : NavController
){
   val profileState = profileViewModel.profileUiState.collectAsState()
   SideEffect {
      if(profileViewModel.getUserName() == null){
         navController.navigateToLoginScreen()
      }else{
         profileViewModel.getAccountDetails()
      }
   }
   ProfileScreenContent(profileState)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileScreenContent(profileState : State<ProfileScreenUiState>) {
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
            profileState.value.profile.avatar?.let { it1 ->
               CoilImage(
                  imageUrl = it1 ,
                  modifier = Modifier
                     .size(150.dp)
                     .clip(RoundedCornerShape(50))
               )
            }

         Spacer(modifier = Modifier.height(5.dp))
         profileState.value.profile.userName?.let { it1 ->
            Text(
               text = it1 , fontSize = 25.sp, fontWeight = FontWeight.Bold
            )
         }

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
