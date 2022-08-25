package com.example.connecttointernet.networking

import com.example.connecttointernet.model.JokeApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeApiService {

    //Specify the request method using annotation
    @GET("joke/any")
    /**
     * suspend: to use kotlin coroutines
     * Response<> class used to determine the request response state(isSuccessful?)
     */
    suspend fun getRandomJoke() : Response<JokeApiResponse>

}