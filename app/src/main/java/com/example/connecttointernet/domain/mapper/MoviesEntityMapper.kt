package com.example.connecttointernet.domain.mapper

import com.example.connecttointernet.data.local.entities.MovieEntity
import com.example.connecttointernet.data.remote.response.MovieDto

class MoviesEntityMapper : Mapper<MovieDto, MovieEntity> {
    override fun map(input: MovieDto): MovieEntity =
        MovieEntity(
            id = input.id ?: 0L,
            title = input.title ?: "",
            vote = input.voteAverage ?: 0.0,
            imgPath = input.posterPath ?: ""
        )
}