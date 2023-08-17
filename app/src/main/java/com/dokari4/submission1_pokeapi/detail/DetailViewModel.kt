package com.dokari4.submission1_pokeapi.detail

import androidx.lifecycle.ViewModel
import com.dokari4.submission1_pokeapi.domain.model.Movie
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}