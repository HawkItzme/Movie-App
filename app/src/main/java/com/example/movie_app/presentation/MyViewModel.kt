package com.example.movie_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movie_app.domain.usecases.GetMoviesUseCase
import com.example.movie_app.domain.usecases.UpdateMoviesUseCase

class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies()  = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}