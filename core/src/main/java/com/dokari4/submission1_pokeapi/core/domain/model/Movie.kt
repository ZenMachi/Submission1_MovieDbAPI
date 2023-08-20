package com.dokari4.submission1_pokeapi.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var id: Int,
    var movieId: Int,
    var title: String,
    var overview: String,
    var releaseDate: String,
    var posterPath: String,
    var backdropPath: String,
    var isFavorite: Boolean
) : Parcelable
