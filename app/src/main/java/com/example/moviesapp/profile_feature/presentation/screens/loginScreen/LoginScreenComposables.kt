package com.example.moviesapp.profile_feature.presentation.screens.loginScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesapp.home_feature.presentation.screens.homeScreen.CoilImage

@Composable
fun LoginScreenHeader(){
   Column(
      modifier = Modifier
         .fillMaxWidth() ,
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      CoilImage(
         imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_iwpPSZsnDqf52czYxFbuRgg_GbqgxUsG2g&usqp=CAU",
         modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
      )

         Text(
            text = "Login to your account" ,
            color = Color.White ,
            modifier = Modifier
               .fillMaxWidth()
               .padding(10.dp) ,
            textAlign = TextAlign.Start ,
            fontSize = 25.sp
         )
}}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenFillingSection(logInClick : (userName : String, password : String) -> Unit){
   Column(
      modifier = Modifier
         .fillMaxWidth() ,
      verticalArrangement = Arrangement.SpaceEvenly,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {

      val userNameState = remember {
         mutableStateOf("")
      }

      TextField(
         value = userNameState.value,
         onValueChange = {
            userNameState.value = it
         },
         leadingIcon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "")
         },
         modifier = Modifier.border(
            BorderStroke(
               width = 2.dp,
               brush = Brush.horizontalGradient(listOf(Color.Red, Color.Red))
            ) ,
            shape = RoundedCornerShape(20)
         ),
         colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
         ),
         placeholder = { Text(text = "user name") }
      )
      val password = remember {
         mutableStateOf("")
      }
      TextField(
         value = password.value,
         onValueChange = {password.value = it},
         leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "")
         },
         modifier = Modifier.border(
            BorderStroke(
               width = 2.dp,
               brush = Brush.horizontalGradient(listOf(Color.Red, Color.Red))
            ) ,
            shape = RoundedCornerShape(20)
         ),
         colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
         ),
         placeholder = { Text(text = "passwrod") }
      )
      Spacer(modifier = Modifier.height(20.dp))
      Box(modifier = Modifier.padding(horizontal = 10.dp)) {
         Button(
            onClick = {
               logInClick(userNameState.value, password.value)
            },
            Modifier
               .fillMaxWidth()
               .height(50.dp)
               .clip(RoundedCornerShape(15.dp)),
            colors = ButtonDefaults.buttonColors(Color.Red)
         ) {
            Text(text = "Login", color = Color.White, fontSize = 25.sp)
         }
      }}
}

@Composable
fun LoginScreenFooter(){
   Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
      Text(text = "do not have an account?", color = Color.White)
      Text(
         text = "sign up",
         color = Color.Red,
         modifier = Modifier.clickable {  })
   }
}