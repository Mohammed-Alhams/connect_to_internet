package com.example.connecttointernet

import com.example.connecttointernet.model.JokeApiResponse
import com.example.connecttointernet.networking.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class JokesRepository {
    /*suspend can omit suspend keyword */ fun getRandomJoke() : Flow<JokeApiResponse?> {
        return flow {
            emit(API.apiService.getRandomJoke().body())
        }
    }
}