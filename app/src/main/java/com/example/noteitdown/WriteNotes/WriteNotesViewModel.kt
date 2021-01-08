package com.example.noteitdown.WriteNotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noteitdown.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WriteNotesViewModel(notesDatabaseDao: NotesDao, notesId:Int, application:Application):AndroidViewModel(application) {
      var _notesData :LiveData<NotesEntity>
    private val repository =NotesRepository(notesDatabaseDao)

    init {
            _notesData= repository.getNote(notesId)
    }

    fun getNote(notesId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _notesData= repository.getNote(notesId)
//            _notesData.value?.let { repository.updateNote(it) }

        }
    }

    fun updateNote(text:String,title:String=_notesData.value?.title.toString())=viewModelScope.launch(Dispatchers.IO) {
        _notesData.value?.let{it.title=title}
        _notesData.value?.let{it.text = text }
        _notesData.value?.let { repository.updateNote(it) }
    }
}