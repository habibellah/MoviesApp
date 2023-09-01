package com.example.moviesapp.profile_feature.presentation.screens.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
   loginViewModel : LoginViewModel = hiltViewModel()
){
   val loginUiState = loginViewModel.loginState.collectAsState()
   LoginScreenContent(loginUiState){userName, password ->
           loginViewModel.onLoginClick(userName, password)
   }
}

@Composable
private fun LoginScreenContent(
   loginUiState : State<LoginUiState> ,
   logInClick : (userName : String , password : String) -> Unit
) {
   Box(modifier = Modifier.fillMaxSize()){
      Column(
         modifier = Modifier
            .fillMaxSize() ,
         verticalArrangement = Arrangement.SpaceAround,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         LoginScreenHeader()
         LoginScreenFillingSection{userName, password ->
         logInClick(userName, password)
         }
         LoginScreenFooter()
      }
   }
}
