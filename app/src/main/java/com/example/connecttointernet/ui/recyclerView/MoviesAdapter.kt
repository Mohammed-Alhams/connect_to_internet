package com.example.connecttointernet.ui.recyclerView

import com.example.connecttointernet.R
import com.example.connecttointernet.model.movie.popular.Movie

class MoviesAdapter(
    movies: List<Movie>,
    listener: IMovieInteractionListener
) : BaseAdapter<Movie>(movies, listener) {
    override val layoutId: Int = R.layout.item_movie
}

interface IMovieInteractionListener : IBaseInterActionListener {
    fun onClickMovie(movie: Movie)
}