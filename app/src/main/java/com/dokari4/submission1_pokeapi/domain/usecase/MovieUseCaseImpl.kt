package com.dokari4.submission1_pokeapi.domain.usecase

import androidx.lifecycle.LiveData
import com.dokari4.submission1_pokeapi.core.data.Resource
import com.dokari4.submission1_pokeapi.domain.model.Movie
import com.dokari4.submission1_pokeapi.domain.repository.IMovieRepository

class MovieUseCaseImpl(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getMovieList(): LiveData<Resource<List<Movie>>> =
        movieRepository.getMovieList()

    override fun getFavoriteMovie(): LiveData<List<Movie>> =
        movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)
}