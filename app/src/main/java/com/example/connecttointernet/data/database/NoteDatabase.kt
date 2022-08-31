package com.example.connecttointernet.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.connecttointernet.data.Note

@Database(entities = [Note::class], version = 1)
@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getDao(): NoteDao

    companion object {

        private const val DATABASE_NAME = "NotesDatabase"

        @Volatile
        private var instance: NoteDatabase? = null

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME)
                /**.fallbackToDestructiveMigration()**///Allows Room to destructively recreate database
//                tables if Migrations that would migrate old database schemas to the latest schema version are not found.
                .build()

        fun getInstance(context: Context) =
            instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }

        fun getInstanceWithoutContext() = instance!!
    }

}