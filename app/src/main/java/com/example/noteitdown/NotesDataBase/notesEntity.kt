package com.example.noteitdown

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class NotesEntity(@ColumnInfo(name = "text") val text:String) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}