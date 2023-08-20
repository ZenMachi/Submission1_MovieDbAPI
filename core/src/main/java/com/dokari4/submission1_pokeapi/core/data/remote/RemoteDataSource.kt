package com.dokari4.submission1_pokeapi.core.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.tourismapp.core.data.source.remote.network.ApiResponse
import com.dicoding.tourismapp.core.data.source.remote.network.ApiService
import com.dokari4.submission1_pokeapi.core.data.remote.response.ListMovieResponse
import com.dokari4.submission1_pokeapi.core.data.remote.response.MovieResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getMovieList(): Flowable<ApiResponse<List<MovieResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<MovieResponse>>>()

        val client = apiService.getMovieList()

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataArray = response.results
                resultData.onNext(
                    if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, {error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })



        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }


}