package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.API
import com.example.connecttointernet.model.JokeApiResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val joke = MutableLiveData<JokeApiResponse>()


    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        viewModelScope.launch {
            joke.postValue(API.apiService.getRandomJoke())
        }

    }

}