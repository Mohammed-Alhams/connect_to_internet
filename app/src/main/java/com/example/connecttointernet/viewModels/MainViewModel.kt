package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.model.JokeApiResponse
import com.example.connecttointernet.model.State
import com.example.connecttointernet.model.repositories.JokesRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val jokesRepo = JokesRepository()

    val jokeLiveData = MutableLiveData<State<JokeApiResponse?>>()

    init {
        getRandomJoke()
    }

//    6- MainViewModel use the data returned from repo as State, and post it as State object
    fun getRandomJoke() {
        viewModelScope.launch {
            jokesRepo.getRandomJoke()//return flow.. so we can collect it
                .collect{
                    jokeLiveData.postValue(it)
                }
        }
    }

}