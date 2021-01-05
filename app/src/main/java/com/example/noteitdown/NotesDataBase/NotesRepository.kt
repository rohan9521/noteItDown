package com.example.noteitdown

import androidx.lifecycle.LiveData

class NotesRepository(private  val notesDao:NotesDao) {

    val allNotes:LiveData<List<NotesEntity>>  = notesDao.fetAllNotes()

    suspend fun insert(note:NotesEntity){
        notesDao.insert(note)
    }
    suspend fun delete(note: NotesEntity){
        notesDao.delete(note)
    }

}