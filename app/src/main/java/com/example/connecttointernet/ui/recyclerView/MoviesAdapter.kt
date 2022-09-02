package com.example.connecttointernet.ui.recyclerView

import com.example.connecttointernet.R
import com.example.connecttointernet.data.remote.response.MovieDto
import com.example.connecttointernet.domain.models.Movie

class MoviesAdapter(
    movies: List<Movie>,
    listener: IMovieInteractionListener
) : BaseAdapter<Movie>(movies, listener) {
    override val layoutId: Int = R.layout.item_movie
}

interface IMovieInteractionListener : IBaseInterActionListener {
    fun onClickMovie(movieDto: MovieDto)
}