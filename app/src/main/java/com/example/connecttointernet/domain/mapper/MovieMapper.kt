package com.example.connecttointernet.domain.mapper

import com.example.connecttointernet.data.local.entities.MovieEntity
import com.example.connecttointernet.domain.models.Movie

class MovieMapper : Mapper<MovieEntity, Movie> {
    override fun map(input: MovieEntity): Movie =
        Movie(
            id = input.id,
            title = input.title,
            vote = input.vote,
            imgUrl = input.imgPath
        )
}