package com.example.connecttointernet.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.connecttointernet.data.local.daos.MovieDao
import com.example.connecttointernet.data.local.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MoviesDatabase : RoomDatabase(){

    abstract fun moviesDao() : MovieDao

    companion object{

        private const val DATABASE_NAME = "moviesDB"

        private var instance : MoviesDatabase? = null

        fun init(context: Context) =
            instance ?: synchronized(this){ buildDatabase(context).also { instance = it } }

        fun getInstance() = instance!!

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MoviesDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

    }

}