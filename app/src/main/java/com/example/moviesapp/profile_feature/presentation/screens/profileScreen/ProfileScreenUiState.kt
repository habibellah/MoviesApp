package com.example.moviesapp.profile_feature.presentation.screens.profileScreen

import com.example.moviesapp.profile_feature.domain.model.Profile

data class ProfileScreenUiState(
   val profile : Profile = Profile() ,
   val error : Boolean = false ,
   val loading : Boolean = false
)