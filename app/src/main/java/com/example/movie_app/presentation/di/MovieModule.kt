package com.example.movie_app.presentation.di

import com.example.movie_app.domain.usecases.GetMoviesUseCase
import com.example.movie_app.domain.usecases.UpdateMoviesUseCase
import com.example.movie_app.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {

        return ViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}