package com.example.movie_app.presentation.di

import com.example.movie_app.data.dataSource.MovieLocalDataSource
import com.example.movie_app.data.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.movie_app.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}