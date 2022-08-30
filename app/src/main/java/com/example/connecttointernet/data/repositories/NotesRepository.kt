package com.example.connecttointernet.data.repositories

import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.database.NoteDatabase
import io.reactivex.rxjava3.core.Completable

class NotesRepository {

    private val notesDao = NoteDatabase.getInstanceWithoutContext().getDao()

    fun insertNote(note: Note) : Completable{
        return notesDao.insertNote(note)
    }

}