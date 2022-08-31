package com.example.connecttointernet.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connecttointernet.data.Note
import com.example.connecttointernet.data.repositories.NotesRepository
import com.example.connecttointernet.ui.IBaseInterActionListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NotesViewModel : ViewModel(), IBaseInterActionListener{

    val noteText = MutableLiveData<String>()

    private val _notes = MutableLiveData<List<Note>>()
    val notes : LiveData<List<Note>> = _notes

    private val repository = NotesRepository()

    init{
        getAllNotes()
    }

    fun insertNote() {
        noteText.value?.let {
            repository.insertNote(Note(0, it, "2.2.2022", false))
                .subscribeOn(Schedulers.io())
                .subscribe()
            noteText.postValue("")
        }
    }

    fun getAllNotes(){
        repository.getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                this::onGetNote,
                this::onGetNoteFail
            )
    }

    private fun onGetNote(notes: List<Note>){
        _notes.postValue(notes)
    }

    private fun onGetNoteFail(throwable: Throwable){

    }

}