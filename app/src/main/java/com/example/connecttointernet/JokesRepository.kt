package com.example.connecttointernet

import com.example.connecttointernet.networking.API

class JokesRepository {
    suspend fun getRandomJoke() = API.apiService.getRandomJoke()
}