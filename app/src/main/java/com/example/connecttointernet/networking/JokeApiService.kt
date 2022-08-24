package com.example.connecttointernet.networking

import com.example.connecttointernet.model.JokeApiResponse
import retrofit2.http.GET

interface JokeApiService {

    @GET("joke/any")//annotation used to specify end point for this function
    suspend fun getRandomJoke(): JokeApiResponse //if using callBacks

}