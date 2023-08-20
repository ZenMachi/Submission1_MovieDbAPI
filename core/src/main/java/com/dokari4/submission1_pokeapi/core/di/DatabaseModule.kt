package com.dokari4.submission1_pokeapi.core.di

import android.content.Context
import androidx.room.Room
import com.dokari4.submission1_pokeapi.core.data.local.room.MovieDao
import com.dokari4.submission1_pokeapi.core.data.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    //To Provide fun provideMovieDao
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "Movie.db")
            .fallbackToDestructiveMigration()
            .build()

    //To Provide in LocalDataSource
    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}