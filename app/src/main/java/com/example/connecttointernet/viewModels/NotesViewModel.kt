package com.example.connecttointernet.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.repositories.NotesRepository
import com.example.connecttointernet.ui.bases.IBaseInterActionListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.util.*

class NotesViewModel : ViewModel(), IBaseInterActionListener {

    private val repository = NotesRepository()

    val noteText = MutableLiveData<String>()
    val searchText = MutableStateFlow("")

    //    private val _notes = MutableLiveData<List<Note>>()
    val notes = MutableLiveData<List<Note>>()

    init {
        viewModelScope.launch {
            repository.getAllNotes().collect {
                notes.postValue(it)
                noteText.postValue("")
            }
        }

        viewModelScope.launch {
            searchText.debounce(1000).collect {
                val result = repository.getFilteredNotes(it)
                notes.postValue(result)
            }
        }
    }

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