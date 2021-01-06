package com.example.noteitdown.WriteNotes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteitdown.NotesDao
import com.example.noteitdown.NotesDatabase
import java.lang.IllegalArgumentException

class WriteNotesViewModelFactory(private val notesDatabaseDao: NotesDao,private val notesId:Int,private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var writeNotesViewModel = WriteNotesViewModel(notesDatabaseDao,notesId,application)
       if(modelClass.isAssignableFrom(WriteNotesViewModel::class.java)){
           return writeNotesViewModel as T
       }
        throw IllegalArgumentException("The view model class writeNotesViewModel is not available")
    }
}