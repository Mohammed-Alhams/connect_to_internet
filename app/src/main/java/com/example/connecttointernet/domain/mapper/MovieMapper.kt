package com.example.connecttointernet.domain.mapper

import com.example.connecttointernet.data.remote.response.MovieDto
import com.example.connecttointernet.domain.models.Movie

class MovieMapper : Mapper<MovieDto, Movie> {
    override fun map(input: MovieDto): Movie =
        Movie(
            id = input.id,
            title = input.title,
            vote = input.voteAverage,
            imgUrl = input.posterPath
        )
}