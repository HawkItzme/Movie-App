package com.example.movie_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movie_app.domain.usecases.GetMoviesUseCase
import com.example.movie_app.domain.usecases.UpdateMoviesUseCase

class ViewModelFactory (
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}