package com.example.movie_app.presentation.di

import com.example.movie_app.domain.repository.MovieRepository
import com.example.movie_app.domain.usecases.GetMoviesUseCase
import com.example.movie_app.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

}