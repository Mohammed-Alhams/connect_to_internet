package com.example.connecttointernet.data.database

import androidx.room.*
import com.example.connecttointernet.data.Note

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNotes(): List<Note>

}