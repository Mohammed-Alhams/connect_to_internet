package com.example.connecttointernet.data.database

import androidx.room.*
import com.example.connecttointernet.data.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Completable

    @Delete
    fun deleteNote(note: Note): Completable

    @Update
    fun updateNote(note: Note): Completable

    @Query("SELECT * FROM Note")
    fun getAllNotes(): Observable<List<Note>>

}