package com.example.movie_app.presentation.di

import com.example.movie_app.data.dataSource.MovieCacheDataSource
import com.example.movie_app.data.dataSourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}