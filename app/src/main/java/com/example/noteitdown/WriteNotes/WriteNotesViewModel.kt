package com.example.noteitdown.WriteNotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteitdown.*

class WriteNotesViewModel(notesDatabaseDao: NotesDao, notesId:Int, application:Application):AndroidViewModel(application) {
    var notesData :LiveData<NotesEntity>
    var repository =NotesRepository(notesDatabaseDao)
    init {
        notesData= repository.notesDao.getNote(notesId)
    }
}