package com.dokari4.favorite2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.dokari4.submission1_pokeapi.core.domain.usecase.MovieUseCase


class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favorite = movieUseCase.getFavoriteMovie().toLiveData()
}