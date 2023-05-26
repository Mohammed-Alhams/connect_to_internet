package com.example.connecttointernet.data.repository

import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.local.NoteDatabase

class NotesRepository {

    private val notesDao = NoteDatabase.getInstanceWithoutContext().getDao()

    suspend fun insertNote(note: Note) {
        notesDao.insertNote(note)
    }

    fun getAllNotes() = notesDao.getAllNotes()

    suspend fun getFilteredNotes(searchTerm: String) =
        notesDao.getFilteredNotes("%$searchTerm%")

}