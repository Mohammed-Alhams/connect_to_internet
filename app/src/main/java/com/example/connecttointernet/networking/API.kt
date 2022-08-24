package com.example.connecttointernet.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object API {

    private val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //Create an implementation of the API endpoints defined by the service interface.
    val apiService = retrofit.create(JokeApiService::class.java)

}

