package com.example.connecttointernet.domain.repositories

import com.example.connecttointernet.data.local.daos.MovieDao
import com.example.connecttointernet.data.remote.MovieApiService
import com.example.connecttointernet.domain.mapper.MovieMapper
import com.example.connecttointernet.domain.mapper.MoviesEntityMapper
import com.example.connecttointernet.domain.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okio.IOException
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val mapperToMovie: MovieMapper,
    private val movieService: MovieApiService,
    private val movieDao: MovieDao,
    private val mapperToEntity: MoviesEntityMapper
) {

    suspend fun refreshMovies() {
        try {
            val response = movieService.getPopular("6f65d57c475f6a1b3a9eedd189c66691")
            val movies = response.body()?.movieDtos?.map {
                mapperToEntity.map(it)
            }
            movies?.let { movieDao.insertMovies(it) }
        } catch (e: IOException){

        }
    }

    fun getPopular(): Flow<List<Movie>> {
        return movieDao.getMovies().map {
            it.map { movieEntity ->
                mapperToMovie.map(movieEntity)
            }
        }
    }

//    fun getPopular(): Flow<State<List<Movie>?>> =
//        flow {
//            emit(State.Loading)
//            try {
//                val movies = movieService
//                    .getPopular("6f65d57c475f6a1b3a9eedd189c66691")
//                    .body()
//                    ?.movieDtos
//                    ?.map { movieDto ->
//                        mapper.map(movieDto)
//                    }
//                emit(State.Success(movies))
//            } catch (e: IOException) {
//                emit(State.Failed(e.message.toString()))
//            }
//        }
//    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
//        flow {
//            emit(State.Loading)
//            try {
//                val response = function()
//                if (response.isSuccessful)
//                    emit(State.Success(response.body()))
//                else
//                    emit(State.Failed(response.message().toString()))
//            } catch (e: Exception) {
//                emit(State.Failed(e.message.toString()))
//            }
//        }


    /*suspend can be omitted suspend keyword */
//    fun getPopular(): Flow<State<PopularResponse?>> /*Using flow we can omit multiple statuses of response*/ {
//        return wrapWithFlow{API.movieService.getPopular("6f65d57c475f6a1b3a9eedd189c66691")}
//    }

//    fun getMovieById() : Flow<State<MovieResponse?>>{
//        return wrapWithFlow(API.movieService::getMovieById)
//    }

//    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
//        return flow {
//            emit(State.Loading)
//            try {
//                val response = function()
//                if (response.isSuccessful)
//                    emit(State.Success(response.body()))
//                else
//                    emit(State.Failed(response.message().toString()))
//            } catch (e: Exception) {
//                emit(State.Failed(e.message.toString()))
//            }
//        }
//    }

}