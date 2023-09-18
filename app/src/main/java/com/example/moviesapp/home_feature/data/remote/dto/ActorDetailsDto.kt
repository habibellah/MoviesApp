package com.example.moviesapp.home_feature.data.remote.dto


import com.example.moviesapp.home_feature.domain.model.ActorDetails
import com.google.gson.annotations.SerializedName

data class ActorDetailsDto(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("also_known_as")
    val alsoKnownAs: List<String?>?,
    @SerializedName("biography")
    val biography: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("deathday")
    val deathday: Any?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("homepage")
    val homepage: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("place_of_birth")
    val placeOfBirth: String,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String
){
    fun toActorDetails() : ActorDetails{
        return ActorDetails(
            profileImage = "https://image.tmdb.org/t/p/w500${profilePath}" ,
            name = name ,
            biography = biography ,
            gender = gender.toString() ,
            placeOfBirth = placeOfBirth ,
            birthDay = birthday ,
            knownFor = alsoKnownAs.toString()
        )
    }
}