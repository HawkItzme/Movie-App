package com.example.movie_app.data.dataSource

import com.example.movie_app.data.model.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies:List<Movie>)

}