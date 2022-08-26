package com.example.connecttointernet.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.connecttointernet.model.MoviesRepository
import com.example.connecttointernet.model.movie.popular.Movie
import com.example.connecttointernet.ui.recyclerView.IMovieInteractionListener

class MoviesViewModel : ViewModel(), IMovieInteractionListener {

    private val moviesRepository = MoviesRepository()

    val movieLiveData = moviesRepository.getPopular().asLiveData()
    override fun onClickMovie(movie: Movie) {

    }

//    init {
//        getPopular()
//    }

//    fun getPopular() {
//        viewModelScope.launch {
//            moviesRepository.getPopular().collect {
//                movieLiveData.postValue(it)
//            }
//        }
//    }
//    val
//    fun getPopular() =
//        flow<> {  }


//    val joke = MutableLiveData<State<JokeApiResponse?>>()//live data now
//
//    val repo = JokesRepository()
//
//    init {
//        getRandomJoke()
//    }
//
//    fun getRandomJoke() {
//        viewModelScope.launch {
//            repo.getRandomJoke().collect{
//                joke.postValue(it)
//            }
//        }
//
//    }
}