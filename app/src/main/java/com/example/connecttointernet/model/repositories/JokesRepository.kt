package com.example.connecttointernet.model.repositories

import com.example.connecttointernet.model.JokeApiResponse
import com.example.connecttointernet.model.State
import com.example.connecttointernet.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class JokesRepository {

    /**
     * Return the data as State encapsulated;
     * so we can check it when observing on it in the view/activity
     */
    suspend fun getRandomJoke(): Flow<State<JokeApiResponse?>> {

        return wrapWithFlow(API.apiService::getRandomJoke)

    }


    private fun <T> wrapWithFlow(function : suspend () -> Response<T>) : Flow<State<T?>>{
        return flow {
            emit(State.Loading)
            try {
                val response = function()
                if (response.isSuccessful)
                    emit(State.Success(response.body()))
                else
                    emit(State.Failed(response.message().toString()))
            } catch (e : Exception){
                emit(State.Failed(e.message.toString()))
            }
        }
    }

}