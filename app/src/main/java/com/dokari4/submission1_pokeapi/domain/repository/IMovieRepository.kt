package com.dokari4.submission1_pokeapi.domain.repository

import androidx.lifecycle.LiveData
import com.dokari4.submission1_pokeapi.core.data.Resource
import com.dokari4.submission1_pokeapi.domain.model.Movie

interface IMovieRepository {

    fun getMovieList(): LiveData<Resource<List<Movie>>>

    fun getFavoriteMovie(): LiveData<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}