package com.example.connecttointernet.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.repositories.NotesRepository
import com.example.connecttointernet.ui.bases.IBaseInterActionListener
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel(), IBaseInterActionListener {

    private val repository = NotesRepository()

    val noteText = MutableLiveData<String>()

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    init {
        getAllNotes()
    }

    fun insertNote(){
        viewModelScope.launch {
            noteText.value?.let {
                repository.insertNote(Note(0, it, "2.2.2022", false))
            }
        }
    }

    private fun getAllNotes(){
        viewModelScope.launch{
            val notes = repository.getAllNotes()
            _notes.postValue(notes)
        }
    }
}