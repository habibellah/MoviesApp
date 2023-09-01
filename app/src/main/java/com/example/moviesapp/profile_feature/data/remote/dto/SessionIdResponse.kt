package com.example.moviesapp.profile_feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SessionIdResponse(
   @SerializedName("session_id")
   val sessionId: String?,
   @SerializedName("success")
   val success: Boolean?
)