package com.example.movie_app.domain.usecases

import com.example.movie_app.data.model.Movie
import com.example.movie_app.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? =  movieRepository.getMovies()

}