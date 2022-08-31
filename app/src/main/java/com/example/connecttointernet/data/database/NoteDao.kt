package com.example.connecttointernet.data.database

import androidx.room.*
import com.example.connecttointernet.data.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY id desc")
    suspend fun getAllNotes(): List<Note>

}