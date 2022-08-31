package com.example.connecttointernet.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.repositories.NotesRepository
import com.example.connecttointernet.ui.bases.IBaseInterActionListener
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesViewModel : ViewModel(), IBaseInterActionListener {

    private val repository = NotesRepository()

    val noteText = MutableLiveData<String>()

    val notes: LiveData<List<Note>> = repository.getAllNotes()

    fun insertNote() {
        noteText.value?.let {
            repository.insertNote(Note(0, it, "2.2.2022", false))
                .subscribeOn(Schedulers.io())
                .subscribe()
            noteText.postValue("")
        }
    }

}