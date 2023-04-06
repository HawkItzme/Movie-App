package com.example.movie_app.data.dataSourceImpl

import com.example.movie_app.data.dataSource.MovieCacheDataSource
import com.example.movie_app.data.model.Movie

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}