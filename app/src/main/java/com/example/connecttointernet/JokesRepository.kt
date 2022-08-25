package com.example.connecttointernet

import com.example.connecttointernet.model.JokeApiResponse
import com.example.connecttointernet.model.State
import com.example.connecttointernet.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class JokesRepository {
    /*suspend can be omitted suspend keyword */
    fun getRandomJoke(): Flow<State<JokeApiResponse?>> /*Using flow we can omit multiple statuses of response*/ {
        return wrapWithFlow(API.apiService::getRandomJoke)
    }

    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
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
    }

}