package com.example.connecttointernet

import com.example.connecttointernet.model.JokeApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokeApiService {

    @GET("joke/any")//annotation used to specify end point for this function
    fun getRandomJoke(): Single<JokeApiResponse> //if using callBacks

}

object API {

    private val BASE_URL = "https://v2.jokeapi.dev/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    //Create an implementation of the API endpoints defined by the service interface.
    val apiService = retrofit.create(JokeApiService::class.java)

}

