package com.example.moviesapp.search_feature.data.remote.dto


import com.example.moviesapp.search_feature.domain.model.MediaSearch
import com.example.moviesapp.search_feature.domain.model.util.MediaType
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("known_for")
    val knownFor: List<KnownFor?>?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
){
    fun toMediaSearch() : MediaSearch{
        return MediaSearch(image = "https://image.tmdb.org/t/p/w500${profilePath}" , mediaType = MediaType.Actor, mediaId = id)
    }
}