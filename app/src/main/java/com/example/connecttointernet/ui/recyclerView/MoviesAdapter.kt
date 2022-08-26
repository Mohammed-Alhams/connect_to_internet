package com.example.connecttointernet.ui.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.connecttointernet.R
import com.example.connecttointernet.databinding.ItemMovieBinding
import com.example.connecttointernet.model.movie.popular.Movie

class MoviesAdapter(
    private var movies: List<Movie>,
    private val listener: IMovieInteractionListener
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    fun setItems(newItems: List<Movie>){
        movies = newItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.binding.apply {
            movie = currentMovie
            listener = listener
        }
    }

    override fun getItemCount() = movies.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMovieBinding.bind(itemView)
    }

}

interface IMovieInteractionListener {
    fun onClickMovie(movie: Movie)
}