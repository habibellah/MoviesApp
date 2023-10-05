package com.example.moviesapp.home_feature.presentation.screens.actorDetailsScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.presentation.navigation.routes.ActorDetailsArgs
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.useCase.GetActorDetailsUseCase
import com.example.moviesapp.home_feature.domain.useCase.GetActorMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
   private val getActorDetailsUseCase : GetActorDetailsUseCase,
   private val getActorMoviesUseCase : GetActorMoviesUseCase,
   savedStateHandle : SavedStateHandle
) : ViewModel() {
   private val _actorUiState : MutableStateFlow<ActorDetailsUiState> =
      MutableStateFlow(ActorDetailsUiState())
   val actorUiState : StateFlow<ActorDetailsUiState> = _actorUiState

  private val args = ActorDetailsArgs(savedStateHandle)
   init {
      getActorDetails(args.id)
      getActorMovies(args.id)
   }

   private fun getActorMovies(id : Int) {
      viewModelScope.launch {
         getActorMoviesUseCase.getActorMoviesBy(id).collect { actorMoviesState ->
            when (actorMoviesState) {
               is MovieState.Error -> {
                  _actorUiState.update { actorDetailsUiState ->
                     actorDetailsUiState.copy(
                        actorMovies = actorDetailsUiState.actorMovies.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _actorUiState.update { actorDetailsUiState ->
                     actorDetailsUiState.copy(
                        actorMovies = actorDetailsUiState.actorMovies.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _actorUiState.update { actorDetailsUiState ->
                     actorDetailsUiState.copy(
                        actorMovies = actorDetailsUiState.actorMovies.copy(
                           error = false ,
                           loading = false ,
                           actorMovies = actorMoviesState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }

   private fun getActorDetails(id : Int) {
      viewModelScope.launch {
         getActorDetailsUseCase.getActorDetailsBy(id).collect { actorInfoState ->
            when (actorInfoState) {
               is MovieState.Error -> {
                  _actorUiState.update { actorDetailsUiState ->
                     actorDetailsUiState.copy(
                        actorInfo = actorDetailsUiState.actorInfo.copy(
                           error = true
                        )
                     )
                  }
               }

               MovieState.Loading -> {
                  _actorUiState.update { actorDetailsUiState ->
                     actorDetailsUiState.copy(
                        actorInfo = actorDetailsUiState.actorInfo.copy(
                           loading = true
                        )
                     )
                  }
               }

               is MovieState.Success -> {
                  _actorUiState.update { actorDetailsUiState ->
                     actorDetailsUiState.copy(
                        actorInfo = actorDetailsUiState.actorInfo.copy(
                           error = false ,
                           loading = false ,
                           actorDetails = actorInfoState.data
                        )
                     )
                  }
               }
            }
         }
      }
   }
}