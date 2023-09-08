package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Media
import com.example.moviesapp.home_feature.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTvShowCategoryList @Inject constructor(private val tvShowRepository : TvShowRepository){
   suspend fun getAllTvShowListBy(tvCategory : String , page : Int) : Result<Flow<MovieState<List<Media>>>> {
      return Result.success(flow {
         tvShowRepository.getTvShowListBy(tvCategory,page).collect{
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