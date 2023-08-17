package com.dokari4.submission1_pokeapi.core.di

import com.dokari4.submission1_pokeapi.core.data.MovieRepository
import com.dokari4.submission1_pokeapi.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    //To Provide in MovieUseCaseImpl
    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository

}