package com.example.movie_app.presentation.di

import com.example.movie_app.data.api.TMDBService
import com.example.movie_app.data.dataSource.MovieRemoteDataSource
import com.example.movie_app.data.dataSourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }
}