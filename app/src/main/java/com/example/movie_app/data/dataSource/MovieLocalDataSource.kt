package com.example.movie_app.data.dataSource

import com.example.movie_app.data.model.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesToDB(movies:List<Movie>)

    suspend fun clearAll()

}