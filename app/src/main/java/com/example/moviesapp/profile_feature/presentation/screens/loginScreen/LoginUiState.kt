package com.example.moviesapp.profile_feature.presentation.screens.loginScreen

import com.example.moviesapp.profile_feature.domain.model.LoginState

data class LoginUiState(
   val loginState : LoginState = LoginState.BeforeClick,
   val loading : Boolean = false,
   val error : Boolean = false
)