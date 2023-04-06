package com.example.movie_app.data.dataSourceImpl

import com.example.movie_app.data.api.TMDBService
import com.example.movie_app.data.dataSource.MovieRemoteDataSource
import com.example.movie_app.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}