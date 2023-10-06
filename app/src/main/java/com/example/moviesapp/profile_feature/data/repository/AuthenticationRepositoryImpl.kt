package com.example.moviesapp.profile_feature.data.repository

import com.example.moviesapp.home_feature.data.remote.MovieApi
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.profile_feature.data.local.SharedPreferences
import com.example.moviesapp.profile_feature.data.remote.dto.UserInputsBody
import com.example.moviesapp.profile_feature.domain.model.LoginState
import com.example.moviesapp.profile_feature.domain.model.Profile
import com.example.moviesapp.profile_feature.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
   private val movieApi : MovieApi,
   private val sharedPreferences : SharedPreferences): AuthenticationRepository {

   override suspend fun logIn(
      userName : String ,
      password : String
   ) : Flow<MovieState<LoginState>> {
      return flow{
         emit(MovieState.Loading)
         try {
            val result = movieApi.getRequestToken()
            if (result.isSuccessful) {
               emit(
                  MovieState.Success(
                     checkLoginInformation(
                        UserInputsBody(
                           password,
                           result.body()?.requestToken,
                           userName
                        )
                     )
                  )
               )
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }

   private suspend fun checkLoginInformation(checkLoginBody : UserInputsBody) : LoginState {
      val response = movieApi.checkLoginInformation(userInformation = checkLoginBody)
      if (response.isSuccessful) {
         if (response.body()?.success == true) {
            val requestToken = response.body()!!.requestToken
            return  getSessionId(requestToken!!)
         }
      }
      return LoginState.FailedLogin
   }

   private suspend fun getSessionId(requestToken : String) : LoginState {
      val response = movieApi.getSessionId(tokenRequest = requestToken)
      if (response.isSuccessful) {
         if (response.body()?.success == true) {
            val sessionId = response.body()!!.sessionId
            return  getAccountId(sessionId!!)
         }
      }
      return LoginState.FailedLogin
   }

   private suspend fun getAccountId(sessionId : String) : LoginState {
      val response = movieApi.getAccountId(sessionId = sessionId)
      return if (response.isSuccessful) {
         response.body()?.id?.let { sharedPreferences.storeAccountId(it) }
         response.body()?.id?.let { sharedPreferences.storeSessionId(sessionId) }
         response.body()?.name?.let { sharedPreferences.storeUserName(it) }
         LoginState.SuccessLogin
      } else {
         LoginState.FailedLogin
      }
   }

   override fun getAccountDetails() : Flow<MovieState<Profile>> {
      return flow {
         emit(MovieState.Loading)
         try {
            val result = movieApi.getAccountDetails(sessionId = sharedPreferences.getSessionId()!!)
            if (result.isSuccessful) {
               emit(MovieState.Success(result.body()!!.toProfile()))
            } else {
               emit(MovieState.Error(result.message()))
            }
         } catch (e : Exception) {
            emit(MovieState.Error(e.message.toString()))
         }
      }
   }
}