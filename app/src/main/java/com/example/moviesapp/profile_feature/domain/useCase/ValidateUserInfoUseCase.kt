package com.example.moviesapp.profile_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.profile_feature.domain.model.LoginState
import com.example.moviesapp.profile_feature.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ValidateUserInfoUseCase @Inject constructor(private val authenticationRepository : AuthenticationRepository) {

   suspend fun login(
      userName : String,
      password : String
   ) : Flow<MovieState<LoginState?>> {
      return authenticationRepository.logIn(userName, password)
   }
}