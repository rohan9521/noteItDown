package com.example.noteitdown

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class NotesViewModel(application: Application): AndroidViewModel(application) {
    val allNotes:LiveData<List<NotesEntity>>
    val job = Job()
    val uiScope = CoroutineScope(job+Dispatchers.Main)
    init {
        val dao = NotesDatabase.getDatabase(application).notesDao()
        val repository = NotesRepository(dao)
        allNotes = repository.allNotes
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
    
}