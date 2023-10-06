package com.example.moviesapp.profile_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.profile_feature.data.local.SharedPreferences
import com.example.moviesapp.profile_feature.domain.model.Profile
import com.example.moviesapp.profile_feature.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUseInfoUseCase @Inject constructor(
   private val sharedPreferences : SharedPreferences,
   private val authenticationRepository : AuthenticationRepository
){

   fun getUserName() = sharedPreferences.getUserName()

   fun getAccountDetails() : Flow<MovieState<Profile?>> {
      return authenticationRepository.getAccountDetails()
   }
}