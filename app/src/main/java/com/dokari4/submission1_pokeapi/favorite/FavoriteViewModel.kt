package com.dokari4.submission1_pokeapi.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(movieUseCase: MovieUseCase) : ViewModel() {
    val favorite = movieUseCase.getFavoriteMovie().toLiveData()
}