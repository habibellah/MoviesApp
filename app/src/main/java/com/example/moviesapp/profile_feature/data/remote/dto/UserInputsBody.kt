package com.example.moviesapp.profile_feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserInputsBody(
   @SerializedName("password")
   val password: String?,
   @SerializedName("request_token")
   val requestToken: String?,
   @SerializedName("username")
   val username: String?
)