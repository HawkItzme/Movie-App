package com.example.movie_app.presentation.di

import com.example.movie_app.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}