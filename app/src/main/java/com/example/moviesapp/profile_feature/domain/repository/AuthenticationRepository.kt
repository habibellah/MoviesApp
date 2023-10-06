package com.example.moviesapp.profile_feature.domain.repository

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.profile_feature.domain.model.LoginState
import com.example.moviesapp.profile_feature.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
   suspend fun logIn(userName : String, password : String) : Flow<MovieState<LoginState>>

   fun getAccountDetails() : Flow<MovieState<Profile>>
}