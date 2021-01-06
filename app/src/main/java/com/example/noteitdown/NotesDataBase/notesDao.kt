package com.example.noteitdown

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Query("Select * from notes_table where id=:key")
    fun getNote(key:Int):LiveData<NotesEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:NotesEntity)

    @Delete
    fun delete(note: NotesEntity)

    @Query("Select * from notes_table order by id ASC")
    fun fetAllNotes():LiveData<List<NotesEntity>>
}