package com.dokari4.submission1_pokeapi.core.data.local

import androidx.lifecycle.LiveData
import com.dokari4.submission1_pokeapi.core.data.local.entity.MovieEntity
import com.dokari4.submission1_pokeapi.core.data.local.room.MovieDao

class LocalDataSource private constructor(private val movieDao: MovieDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(movieDao)
            }
    }

    fun getMovieList(): LiveData<List<MovieEntity>> = movieDao.getMovieList()

    fun getFavoriteMovie(): LiveData<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

}