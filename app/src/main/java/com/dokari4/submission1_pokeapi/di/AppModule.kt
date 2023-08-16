package com.dokari4.submission1_pokeapi.di

import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    //To Provide in ViewModelFactory
    @Binds
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}