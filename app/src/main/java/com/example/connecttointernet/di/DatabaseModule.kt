package com.example.connecttointernet.di

import android.content.Context
import androidx.room.Room
import com.example.connecttointernet.data.local.MoviesDatabase
import com.example.connecttointernet.data.local.daos.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return Room.databaseBuilder(context, MoviesDatabase::class.java, "moviesDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMoviesDao(moviesDatabase: MoviesDatabase): MovieDao = moviesDatabase.moviesDao()

}