package com.example.movie_app.domain.repository

import com.example.movie_app.data.model.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?


}