package com.example.moviesapp.home_feature.presentation.screens.seeAllScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.core.presentation.navigation.routes.SeeAllScreenArgs
import com.example.moviesapp.core.presentation.pagination.DefaultPagination
import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Media
import com.example.moviesapp.home_feature.domain.useCase.GetAllMovieCategoryList
import com.example.moviesapp.home_feature.domain.useCase.GetAllTvShowCategoryList
import com.example.moviesapp.home_feature.domain.useCase.GetTrendingTvShowUseCase
import com.example.moviesapp.search_feature.domain.model.util.MediaType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeAllViewModel @Inject constructor(
   private val getAllMovieCategoryList : GetAllMovieCategoryList,
   private val getAllTvShowCategoryList : GetAllTvShowCategoryList,
   private val getTrendingTvShowUseCase : GetTrendingTvShowUseCase,
   savedStateHandle : SavedStateHandle
) : ViewModel() {

  private val args : SeeAllScreenArgs = SeeAllScreenArgs(savedStateHandle)

   var state : MutableStateFlow<SeeAllUiState> = MutableStateFlow(SeeAllUiState())
   private val pagination = DefaultPagination<Int , List<Media>>(
      initialKey = state.value.page ,
      onLoadUpdated = {
         state.update { allUiState -> allUiState.copy(loading = it) }
      } ,
      onRequest = { nextPage ->
       getMediaList(page = nextPage)
      } ,
      getNextKey = {
         state.value.page + 1
      } ,
      onError = {
         state.update { allUiState -> allUiState.copy(error = true) }
      } ,
      onSuccess = { items , newKey ->
         val allItems : MutableList<Media> = mutableListOf()
         items.collect {
            when (it) {
               is MovieState.Error -> {
                  state.update { allUiState -> allUiState.copy(error = true) }
               }

               MovieState.Loading -> {
                  state.update { allUiState -> allUiState.copy(requestLoading = true) }
               }

               is MovieState.Success -> {
                  allItems.addAll(state.value.mediaList)
                  allItems.addAll(it.data)
                  state.update { allUiState ->
                     allUiState.copy(
                        error = false ,
                        requestLoading = false ,
                        endReached = it.data.isEmpty() ,
                        page = newKey ,
                        mediaList = allItems
                     )
                  }
               }
            }
         }
      }
   )

private suspend fun getMediaList(page : Int) : Result<Flow<MovieState<List<Media>>>>{
  return if(args.mediaType == MediaType.TvShow){
      if(args.mediaCategory == "trending"){
         getTrendingTvShowUseCase.getTrendingTvShowList(page)
      }else{
         getAllTvShowCategoryList.getAllTvShowListBy(args.mediaCategory,page)
      }
   }else{
      getAllMovieCategoryList.getAllMovieListBy(args.mediaCategory,page)
   }
}
   init {
      loadNextItems()
   }

   fun loadNextItems() {
      viewModelScope.launch {
         pagination.loadNextItems()
      }
   }
}