package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.repositories.NotesRepository

class NotesViewModel : ViewModel() {

    val noteText = MutableLiveData<String>()

    private val repository = NotesRepository()

    fun insertNote() {
        noteText.value?.let {
            repository.insertNote(Note(0, it, "2.2.2022", false))
            noteText.postValue("")
        }
    }

}