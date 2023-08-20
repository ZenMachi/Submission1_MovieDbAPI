package com.dokari4.submission1_pokeapi.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.dokari4.submission1_pokeapi.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getMovieList().toLiveData()
}