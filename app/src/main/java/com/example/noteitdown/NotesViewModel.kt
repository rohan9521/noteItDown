package com.example.noteitdown

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NotesViewModel(application: Application): AndroidViewModel(application) {
    val allNotes:LiveData<List<NotesEntity>>

    init {
        val dao = NotesDatabase.getDatabase(application).notesDao()
        val repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }
}