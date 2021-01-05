package com.example.noteitdown

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import java.lang.IllegalArgumentException

class NotesViewModelFactory(private var notesDataBaseDao:NotesDao,private var application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var notesViewModel = NotesViewModel(notesDataBaseDao,application)
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)){
            return notesViewModel as T
        }
        throw  IllegalArgumentException("ViewModelClass Not Found")
    }
}