package com.example.noteitdown

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*

class NotesViewModel(notesDataBaseDao:NotesDao,application: Application): AndroidViewModel(application) {

    val allNotes :LiveData<List<NotesEntity>>

    val repository = NotesRepository(notesDataBaseDao)
    val job = Job()
    val uiScope = CoroutineScope(job+Dispatchers.Main)
    init {
        allNotes = repository.notesDao.fetAllNotes()
    }

    fun deleteNotes(notes: NotesEntity)=viewModelScope.launch(Dispatchers.IO) {
        repository.notesDao.delete(notes)
    }

    fun insertNotes(notes: NotesEntity)=viewModelScope.launch(Dispatchers.IO) {
            repository.notesDao.insert(notes)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
    
}