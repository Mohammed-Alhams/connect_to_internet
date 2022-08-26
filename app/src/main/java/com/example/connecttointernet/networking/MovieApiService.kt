package com.example.connecttointernet.networking

import com.example.connecttointernet.model.movie.popular.PopularResponse
import retrofit2.Response
import retrofit2.http.*

interface MovieApiService {

//    @GET("movie/{movie_id}")
//    suspend fun getMovieById(
//        @Path("movie_id") movieId: Int,
//        @Query("api_key") apiKey: String,
//        @Query("language") language: String,
//        @Query("append_to_response") appendToResponse: String
//    ): Response<MovieResponse>
//
//    @FormUrlEncoded
//    @POST("movie/{movie_id}/rating")
//    fun rateMovie(
//        @Path("movie_id") movieId: Int,
//        @Query("api_key") apiKey: String,
//        @Query("guest_session_id") guestSessionId: String,
//        @Query("session_id") sessionId: String,
//        @Body body: RateBody
//    ): Response<RateResponse>

    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String
    ): Response<PopularResponse>

//    @GET("joke/any")//annotation used to specify end point for this function
//    suspend fun getRandomJoke(): Response<JokeApiResponse> //if using callBacks
//    //Response class used to check the state of the fetched data
}