package com.example.movie_app.presentation.di

import com.example.movie_app.data.MovieRepositoryImpl
import com.example.movie_app.data.dataSource.MovieCacheDataSource
import com.example.movie_app.data.dataSource.MovieLocalDataSource
import com.example.movie_app.data.dataSource.MovieRemoteDataSource
import com.example.movie_app.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource

    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

}