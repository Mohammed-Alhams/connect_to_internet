package com.example.connecttointernet.data.repositories

import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.database.NoteDatabase

class NotesRepository {

    private val notesDao = NoteDatabase.getInstanceWithoutContext().getDao()

    fun insertNote(note: Note){
        notesDao.insertNote(note)
    }

}