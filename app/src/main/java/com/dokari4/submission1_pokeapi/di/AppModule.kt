package com.dokari4.submission1_pokeapi.di

import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    //To Provide in HomeViewModel and DetailViewModel
    @Binds
    @ViewModelScoped
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}