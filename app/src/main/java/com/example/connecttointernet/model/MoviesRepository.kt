package com.example.connecttointernet.model

import com.example.connecttointernet.model.movie.popular.PopularResponse
import com.example.connecttointernet.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MoviesRepository {

    fun getPopular(): Flow<State<PopularResponse?>> =
        wrapWithFlow { API.movieService.getPopular("6f65d57c475f6a1b3a9eedd189c66691") }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
            emit(State.Loading)
            try {
                val response = function()
                if (response.isSuccessful)
                    emit(State.Success(response.body()))
                else
                    emit(State.Failed(response.message().toString()))
            } catch (e: Exception) {
                emit(State.Failed(e.message.toString()))
            }
        }


    /*suspend can be omitted suspend keyword */
//    fun getPopular(): Flow<State<PopularResponse?>> /*Using flow we can omit multiple statuses of response*/ {
//        return wrapWithFlow{API.movieService.getPopular("6f65d57c475f6a1b3a9eedd189c66691")}
//    }

//    fun getMovieById() : Flow<State<MovieResponse?>>{
//        return wrapWithFlow(API.movieService::getMovieById)
//    }

//    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val response = function()
//                if (response.isSuccessful)
//                    emit(State.Success(response.body()))
//                else
//                    emit(State.Failed(response.message().toString()))
//            } catch (e: Exception) {
//                emit(State.Failed(e.message.toString()))
//            }
//        }
//    }

}