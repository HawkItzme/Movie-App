package com.example.movie_app.presentation.di

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}