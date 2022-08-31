package com.example.connecttointernet.viewModels

import androidx.lifecycle.*
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.repositories.NotesRepository
import com.example.connecttointernet.ui.bases.IBaseInterActionListener
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel(), IBaseInterActionListener {

    private val repository = NotesRepository()

    val noteText = MutableLiveData<String>()

//    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = repository.getAllNotes().asLiveData()

//    init {
//        getAllNotes()
//    }

    fun insertNote() {
        viewModelScope.launch {
            noteText.value?.let {
                repository.insertNote(Note(0, it, Date(), false))
            }
        }
    }

//    private fun getAllNotes() {
//        viewModelScope.launch {
//            repository.getAllNotes().collect {
//                _notes.postValue(it)
//                noteText.postValue("")
//            }
//        }
//    }
}