package com.example.noteitdown

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*

class NotesViewModel(notesDataBaseDao:NotesDao,application: Application): AndroidViewModel(application) {

    lateinit var allNotes :LiveData<List<NotesEntity>>

    val repository = NotesRepository(notesDataBaseDao)

    var lastNotesEntity:Int = -1

    init {
        fetchAllNotes()
    }

    fun fetchAllNotes()=viewModelScope.launch (Dispatchers.IO){
        allNotes = repository.fetchAll()
    }

    fun getLastNoteAdded()=viewModelScope.launch(Dispatchers.IO) {
        lastNotesEntity=repository.getLast().id
    }


    fun insertNotes(notes: NotesEntity)=viewModelScope.launch(Dispatchers.IO) {
            repository.notesDao.insert(notes)
    }

    fun deleteAll()=viewModelScope.launch (Dispatchers.IO){
        repository.deleteAll()
    }

    fun deleteNotes(notes: NotesEntity)=viewModelScope.launch(Dispatchers.IO) {
        repository.notesDao.delete(notes)
    }

    fun updateNote(notes: NotesEntity)=viewModelScope.launch (Dispatchers.IO){
        repository.updateNote(note = notes)
    }





    override fun onCleared() {
        super.onCleared()

    }
    
}