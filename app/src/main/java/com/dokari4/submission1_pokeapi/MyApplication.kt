package com.dokari4.submission1_pokeapi

import android.app.Application
import com.dokari4.submission1_pokeapi.core.di.CoreComponent
import com.dokari4.submission1_pokeapi.core.di.DaggerCoreComponent
import com.dokari4.submission1_pokeapi.di.AppComponent
import com.dokari4.submission1_pokeapi.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}