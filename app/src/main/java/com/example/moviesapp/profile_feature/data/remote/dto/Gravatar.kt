package com.example.moviesapp.profile_feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Gravatar(
   @SerializedName("hash")
   val hash: String?
)