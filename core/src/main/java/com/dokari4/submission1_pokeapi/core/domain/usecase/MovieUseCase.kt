package com.dokari4.submission1_pokeapi.core.domain.usecase

import com.dokari4.submission1_pokeapi.core.data.Resource
import com.dokari4.submission1_pokeapi.core.domain.model.Movie
import io.reactivex.Flowable

interface MovieUseCase {

    fun getMovieList(): Flowable<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flowable<List<Movie>>

    fun getMovieDetail(movieId: Int): Flowable<Boolean>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}