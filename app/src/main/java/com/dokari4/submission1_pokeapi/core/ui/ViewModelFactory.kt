package com.dokari4.submission1_pokeapi.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dokari4.submission1_pokeapi.core.di.Injection
import com.dokari4.submission1_pokeapi.detail.DetailViewModel
import com.dokari4.submission1_pokeapi.domain.usecase.MovieUseCase
import com.dokari4.submission1_pokeapi.home.HomeViewModel

class ViewModelFactory private constructor(private val movieUseCase: MovieUseCase) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideMovieUseCase(context))
            }
    }

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