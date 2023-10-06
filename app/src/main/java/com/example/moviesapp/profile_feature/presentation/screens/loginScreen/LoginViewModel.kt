package com.example.moviesapp.profile_feature.presentation.screens.loginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.profile_feature.domain.useCase.ValidateUserInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
   private val validateUserInfoUseCase : ValidateUserInfoUseCase
): ViewModel() {

   private val _loginState : MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
   val loginState : StateFlow<LoginUiState> = _loginState

   fun onLoginClick(userName : String,password : String){
      viewModelScope.launch {
         validateUserInfoUseCase.login(userName, password).collect{loginStateResult ->
            when(loginStateResult){
               is MovieState.Error -> {
                  _loginState.update { loginUiState -> loginUiState.copy(error = true) }
               }
               MovieState.Loading -> {
                  _loginState.update { loginUiState -> loginUiState.copy(loading = true) }
               }
               is MovieState.Success -> {
                  _loginState.update { loginUiState -> loginUiState.copy(error = false, loading = false, loginState = loginStateResult.data!!) }
               }

               else -> {}
            }
         }
      }
   }
}