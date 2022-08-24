package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connecttointernet.API
import com.example.connecttointernet.model.JokeApiResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val joke = MutableLiveData<JokeApiResponse>()


    init {
        getRandomJoke()
    }

    private fun getRandomJoke() {
        API.apiService.getRandomJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    joke.postValue(it)
                },
                {

                }
            )
    }

}