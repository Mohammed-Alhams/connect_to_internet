package com.example.connecttointernet.di

import com.example.connecttointernet.data.local.daos.MovieDao
import com.example.connecttointernet.data.remote.MovieApiService
import com.example.connecttointernet.domain.mapper.MovieMapper
import com.example.connecttointernet.domain.mapper.MoviesEntityMapper
import com.example.connecttointernet.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        movieMapper: MovieMapper,
        movieService: MovieApiService,
        moviesEntityMapper: MoviesEntityMapper,
        movieDao: MovieDao
    ): MoviesRepository = MoviesRepository(movieMapper, movieService, movieDao, moviesEntityMapper)

    @Provides
    fun provideMapper(): MovieMapper = MovieMapper()

    @Provides
    fun provideEntityMapper(): MoviesEntityMapper = MoviesEntityMapper()

}