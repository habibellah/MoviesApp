package com.example.moviesapp.home_feature.presentation.screens.actorDetailsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.search_feature.domain.model.util.MediaType

@Composable
fun ActorDetailsScreen(
   actorDetailsViewModel : ActorDetailsViewModel = hiltViewModel()
) {
   val actorDetailsState = actorDetailsViewModel.actorUiState.collectAsState()
   ActorDetailsScreenContent(actorDetailsState)
}

@Composable
private fun ActorDetailsScreenContent(actorDetailsState : State<ActorDetailsUiState>) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)
   ) {
      Column(modifier = Modifier.fillMaxSize()) {
         ActorDetailsHeader(
            imageUrl = actorDetailsState.value.actorInfo.actorDetails?.profileImage ?: "" ,
            actorName = actorDetailsState.value.actorInfo.actorDetails?.name ?: ""
         )
         ActorDetailsBody(
            movieList = actorDetailsState.value.actorMovies.actorMovies ,
            biography =  actorDetailsState.value.actorInfo.actorDetails?.biography ?: "",
            gender = actorDetailsState.value.actorInfo.actorDetails?.gender ?: "" ,
            birthday = actorDetailsState.value.actorInfo.actorDetails?.birthDay ?: "" ,
            placeOfBirth =actorDetailsState.value.actorInfo.actorDetails?.placeOfBirth ?: "" ,
            knownFor = actorDetailsState.value.actorInfo.actorDetails?.knownFor ?: ""
         )
      }
   }
}
