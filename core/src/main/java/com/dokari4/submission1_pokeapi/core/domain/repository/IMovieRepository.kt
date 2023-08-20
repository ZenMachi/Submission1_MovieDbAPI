package com.dokari4.submission1_pokeapi.core.domain.repository

import com.dokari4.submission1_pokeapi.core.data.Resource
import com.dokari4.submission1_pokeapi.core.domain.model.Movie
import io.reactivex.Flowable

interface IMovieRepository {

    fun getMovieList(): Flowable<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flowable<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}