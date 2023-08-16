package com.dokari4.submission1_pokeapi.core.di

import com.dokari4.submission1_pokeapi.core.data.MovieRepository
import com.dokari4.submission1_pokeapi.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class, NetworkModule::class])
abstract class RepositoryModule {

    //To Provide in MovieUseCaseImpl & MovieRepository
    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository

}