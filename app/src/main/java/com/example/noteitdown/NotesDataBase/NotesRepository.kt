package com.example.noteitdown

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NotesRepository(public val notesDao:NotesDao) {

    val allNotes: LiveData<List<NotesEntity>> = notesDao.fetAllNotes()

    fun insert(note:NotesEntity){
        notesDao.insert(note)
    }
    fun delete(note: NotesEntity){
        notesDao.delete(note)
    }

}