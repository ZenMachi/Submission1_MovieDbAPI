package com.dokari4.submission1_pokeapi.core.data

import com.dicoding.tourismapp.core.data.source.remote.network.ApiResponse
import com.dokari4.submission1_pokeapi.core.data.local.LocalDataSource
import com.dokari4.submission1_pokeapi.core.data.remote.RemoteDataSource
import com.dokari4.submission1_pokeapi.core.data.remote.response.MovieResponse
import com.dokari4.submission1_pokeapi.core.domain.model.Movie
import com.dokari4.submission1_pokeapi.core.domain.repository.IMovieRepository
import com.dokari4.submission1_pokeapi.core.utils.AppExecutors
import com.dokari4.submission1_pokeapi.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {



    override fun getMovieList(): Flowable<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getMovieList().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun createCall(): Flowable<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getMovieList()


            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data.isNullOrEmpty()


        }.asFlowable()

    override fun getFavoriteMovie(): Flowable<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
    }
}