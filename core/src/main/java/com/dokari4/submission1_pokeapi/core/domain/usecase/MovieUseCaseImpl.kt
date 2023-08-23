package com.dokari4.submission1_pokeapi.core.domain.usecase

import com.dokari4.submission1_pokeapi.core.data.Resource
import com.dokari4.submission1_pokeapi.core.domain.model.Movie
import com.dokari4.submission1_pokeapi.core.domain.repository.IMovieRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(private val movieRepository: IMovieRepository):
    MovieUseCase {
    override fun getMovieList(): Flowable<Resource<List<Movie>>> =
        movieRepository.getMovieList()

    override fun getFavoriteMovie(): Flowable<List<Movie>> =
        movieRepository.getFavoriteMovie()

    override fun getMovieDetail(movieId: Int): Flowable<Boolean> =
        movieRepository.getMovieDetail(movieId)

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)
}