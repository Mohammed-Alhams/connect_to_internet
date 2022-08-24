package com.example.connecttointernet.viewModels

import androidx.lifecycle.ViewModel
import com.example.connecttointernet.API
import com.example.connecttointernet.model.JokeApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        API.apiService.getRandomJoke().enqueue(object : Callback<JokeApiResponse> {
            override fun onResponse(
                call: Call<JokeApiResponse>,
                response: Response<JokeApiResponse>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<JokeApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}