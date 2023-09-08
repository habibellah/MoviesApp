package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Media
import com.example.moviesapp.home_feature.domain.model.Movie
import com.example.moviesapp.home_feature.domain.model.TvShow
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTvShowCategoryList @Inject constructor(private val tvShowRepository : TvShowRepository){
   suspend fun getAllTvShowCategoryList(movieCategory : String , page : Int) : Result<Flow<MovieState<List<Media>>>> {
      return Result.success(flow {
         tvShowRepository.getTvShowListBy(movieCategory,page).collect{
            when(it){
               is MovieState.Error -> {
                  emit(MovieState.Error(it.message))
               }
               MovieState.Loading -> {
                  emit(MovieState.Loading)
               }
               is MovieState.Success -> {
                  emit(MovieState.Success(it.data.map { tvShow -> tvShow.toMedia() }))
               }
            }
         }
      })
   }
}