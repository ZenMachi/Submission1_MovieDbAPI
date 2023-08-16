package com.dokari4.submission1_pokeapi.core.di

import android.content.Context
import androidx.room.Room
import com.dokari4.submission1_pokeapi.core.data.local.room.MovieDao
import com.dokari4.submission1_pokeapi.core.data.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase =
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