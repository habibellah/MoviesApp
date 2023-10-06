package com.example.moviesapp.profile_feature.presentation.screens.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.profile_feature.domain.useCase.GetUseInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
   private val getUseInfoUseCase : GetUseInfoUseCase
): ViewModel() {


   private val _profileUiState : MutableStateFlow<ProfileScreenUiState> = MutableStateFlow(ProfileScreenUiState())
   val profileUiState : StateFlow<ProfileScreenUiState> = _profileUiState.asStateFlow()
   fun getUserName() = getUseInfoUseCase.getUserName()

   fun getAccountDetails(){
      viewModelScope.launch {
         getUseInfoUseCase.getAccountDetails().collect{ accountDetails ->
            when(accountDetails){
               is MovieState.Error -> {
                  _profileUiState.update { profileScreenUiState -> profileScreenUiState.copy(error = true) }
               }
               MovieState.Loading -> {
                  _profileUiState.update { profileScreenUiState -> profileScreenUiState.copy(loading = true) }
               }
               is MovieState.Success -> {
                  _profileUiState.update { profileScreenUiState -> profileScreenUiState.copy(profile = accountDetails.data!!) }
               }
            }
         }
      }
   }
}