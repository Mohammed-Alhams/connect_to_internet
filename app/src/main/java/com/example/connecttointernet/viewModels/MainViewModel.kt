package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.JokesRepository
import com.example.connecttointernet.networking.API
import com.example.connecttointernet.model.JokeApiResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val joke = MutableLiveData<JokeApiResponse>()

    val repo = JokesRepository()

    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        viewModelScope.launch {
            repo.getRandomJoke().collect{
                joke.postValue(it)
            }
        }

    }

}