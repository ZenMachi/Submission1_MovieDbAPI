package com.dokari4.submission1_pokeapi.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dokari4.submission1_pokeapi.core.data.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("select * from movie")
    fun getMovieList(): LiveData<List<MovieEntity>>

    @Query("select * from movie where isFavorite = 1")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)
}