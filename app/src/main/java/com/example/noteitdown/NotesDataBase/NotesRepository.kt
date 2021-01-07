package com.example.noteitdown

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NotesRepository(public val notesDao:NotesDao) {

    val allNotes: LiveData<List<NotesEntity>> = notesDao.fetAllNotes()
//Create
    suspend  fun insert(note:NotesEntity){
        notesDao.insert(note)
    }

//Retreive
    suspend fun fetchAll():LiveData<List<NotesEntity>>{
        return notesDao.fetAllNotes()
    }
    fun  getNote(noteId:Int):LiveData<NotesEntity>{
        return notesDao.getNote(noteId)
    }

//Update
    suspend fun updateNote(note: NotesEntity){
        notesDao.updateNote(note)
    }

//Delete
    suspend fun deleteAll(){
        notesDao.deleteAll()
    }
    suspend  fun delete(note: NotesEntity){
        notesDao.delete(note)
    }


}