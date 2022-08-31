package com.example.connecttointernet.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.connecttointernet.data.Note
import io.reactivex.rxjava3.core.Completable

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Completable

    @Delete
    fun deleteNote(note: Note): Completable

    @Update
    fun updateNote(note: Note): Completable

    @Query("SELECT * FROM Note ORDER BY id desc")
    fun getAllNotes(): LiveData<List<Note>>

}