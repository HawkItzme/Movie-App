package com.example.movie_app.data.dataSource

import com.example.movie_app.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>

}