package com.example.movie_app.presentation.di

import com.example.movie_app.presentation.MainActivity
import com.example.movie_app.presentation.fragments.PopularMovie
import com.example.movie_app.presentation.fragments.PopularTV
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MainActivity)
    fun inject(fragment: PopularMovie)
    fun inject(fragment: PopularTV)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}