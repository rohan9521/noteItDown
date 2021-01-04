package com.example.noteitdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val notesDao = NotesDatabase.getDatabase(this).notesDao()
        val viewModelFactory = NotesViewModelFactory(notesDao,application)
        val viewModel = ViewModelProvider(this,
           viewModelFactory).get(NotesViewModel::class.java)
        setContentView(R.layout.activity_main)

    }
}