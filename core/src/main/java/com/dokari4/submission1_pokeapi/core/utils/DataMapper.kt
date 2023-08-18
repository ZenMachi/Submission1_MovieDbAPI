package com.dokari4.submission1_pokeapi.core.utils
import com.dokari4.submission1_pokeapi.core.data.local.entity.MovieEntity
import com.dokari4.submission1_pokeapi.core.data.remote.response.MovieResponse
import com.dokari4.submission1_pokeapi.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                isFavorite = it.isFavorite

            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        releaseDate = input.releaseDate,
        posterPath = input.posterPath,
        backdropPath = input.backdropPath,
        isFavorite = input.isFavorite

    )
}