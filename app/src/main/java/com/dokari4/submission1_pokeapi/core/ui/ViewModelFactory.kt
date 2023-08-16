package com.dokari4.submission1_pokeapi.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dokari4.submission1_pokeapi.detail.DetailViewModel
import com.dokari4.submission1_pokeapi.di.AppScope
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import com.dokari4.submission1_pokeapi.home.HomeViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(movieUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(movieUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class : " + modelClass.name)
        }

}