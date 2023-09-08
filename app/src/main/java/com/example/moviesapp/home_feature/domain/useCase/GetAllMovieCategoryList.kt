package com.example.moviesapp.home_feature.domain.useCase

import com.example.moviesapp.home_feature.domain.MovieState
import com.example.moviesapp.home_feature.domain.model.Media
import com.example.moviesapp.home_feature.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllMovieCategoryList @Inject constructor(private val movieRepository : MovieRepository){
   suspend fun getAllMovieListBy(movieCategory : String , page : Int) : Result<Flow<MovieState<List<Media>>>> {
      return Result.success(flow {
         movieRepository.getMovieListBy(movieCategory,page).collect{
            when(it){
               is MovieState.Error -> {
                  emit(MovieState.Error(it.message))
               }
               MovieState.Loading -> {
                  emit(MovieState.Loading)
               }
               is MovieState.Success -> {
                  emit(MovieState.Success(it.data.map { movie -> movie.toMedia() }))
               }
            }
         }
      })
   }
}