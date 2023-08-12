package com.dokari4.submission1_pokeapi.core.di

import android.content.Context
import com.dicoding.tourismapp.core.data.source.remote.network.ApiConfig
import com.dokari4.submission1_pokeapi.core.data.MovieRepository
import com.dokari4.submission1_pokeapi.core.data.local.LocalDataSource
import com.dokari4.submission1_pokeapi.core.data.local.room.MovieDatabase
import com.dokari4.submission1_pokeapi.core.data.remote.RemoteDataSource
import com.dokari4.submission1_pokeapi.core.utils.AppExecutors
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCaseImpl

object Injection {

    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideMovieUseCase(context: Context): MovieUseCase {
        val repository = provideRepository(context)
        return MovieUseCaseImpl(repository)
    }
}