package com.dokari4.submission1_pokeapi.di


import com.dokari4.submission1_pokeapi.core.domain.usecase.MovieUseCase
import com.dokari4.submission1_pokeapi.core.domain.usecase.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {


    @Binds
    @Singleton
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}