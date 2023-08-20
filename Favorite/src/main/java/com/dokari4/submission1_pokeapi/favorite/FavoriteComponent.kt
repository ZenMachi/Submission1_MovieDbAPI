package com.dokari4.submission1_pokeapi.favorite

import android.content.Context
import com.dokari4.submission1_pokeapi.di.FavoriteModuleDepedencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDepedencies::class])
interface FavoriteComponent {

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDepedencies: FavoriteModuleDepedencies): Builder
        fun build(): FavoriteComponent
    }
    fun inject(activity: FavoriteActivity)
}