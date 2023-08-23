package com.dokari4.submission1_pokeapi.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dokari4.submission1_pokeapi.core.data.local.entity.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Query("select * from movie")
    fun getMovieList(): Flowable<List<MovieEntity>>

    @Query("select * from movie where isFavorite = 1")
    fun getFavoriteMovie(): Flowable<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>): Completable

    @Query("select EXISTS (select 1 from movie where id = :movieId AND isFavorite = 1)")
    fun getMovieDetail(movieId: Int): Flowable<Boolean>

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)
}