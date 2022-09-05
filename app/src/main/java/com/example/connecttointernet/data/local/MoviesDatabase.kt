package com.example.connecttointernet.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.connecttointernet.data.local.daos.MovieDao
import com.example.connecttointernet.data.local.entities.MovieEntity
import javax.inject.Inject

@Database(entities = [MovieEntity::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun moviesDao(): MovieDao

    @Inject
    lateinit var instance: MoviesDatabase

//    companion object {
//
//        private const val DATABASE_NAME = "moviesDB"
//
//
////        fun init() =
////            instance ?: synchronized(this){  }
//
//        fun getMovieDatabaseInstance() = synchronized(this) { instance }
//    }

//        private fun buildDatabase(@ApplicationContext context: Context) =
//            Room.databaseBuilder(context, MoviesDatabase::class.java, DATABASE_NAME)
//                .fallbackToDestructiveMigration()
//                .build()

}

