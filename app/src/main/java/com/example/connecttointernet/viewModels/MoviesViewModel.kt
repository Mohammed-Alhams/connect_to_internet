package com.example.connecttointernet.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.data.remote.response.MovieDto
import com.example.connecttointernet.domain.models.Movie
import com.example.connecttointernet.domain.repositories.MoviesRepository
import com.example.connecttointernet.ui.recyclerView.IMovieInteractionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    moviesRepository: MoviesRepository
) : ViewModel(), IMovieInteractionListener {

    init {
        viewModelScope.launch {
            moviesRepository.refreshMovies()
        }
    }

    val movieLiveData: LiveData<List<Movie>?> = moviesRepository.getPopular().asLiveData()

    override fun onClickMovie(movieDto: MovieDto) {

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