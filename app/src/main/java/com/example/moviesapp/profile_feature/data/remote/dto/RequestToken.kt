package com.example.moviesapp.profile_feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RequestToken(
   @SerializedName("expires_at")
   val expiresAt: String?,
   @SerializedName("request_token")
   val requestToken: String?,
   @SerializedName("success")
   val success: Boolean?
)