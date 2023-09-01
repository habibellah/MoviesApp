package com.example.moviesapp.profile_feature.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Avatar(
   @SerializedName("gravatar")
   val gravatar: Gravatar?,
   @SerializedName("tmdb")
   val tmdb: Tmdb?
)