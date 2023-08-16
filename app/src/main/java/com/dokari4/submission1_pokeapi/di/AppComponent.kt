package com.dokari4.submission1_pokeapi.di

import com.dokari4.submission1_pokeapi.core.di.CoreComponent
import com.dokari4.submission1_pokeapi.detail.DetailActivity
import com.dokari4.submission1_pokeapi.home.HomeActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: HomeActivity)
    fun inject(activity: DetailActivity)
}