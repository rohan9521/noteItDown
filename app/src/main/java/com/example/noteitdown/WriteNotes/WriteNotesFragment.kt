package com.example.noteitdown

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.noteitdown.WriteNotes.WriteNotesViewModel
import com.example.noteitdown.WriteNotes.WriteNotesViewModelFactory
import com.example.noteitdown.databinding.FragmentWriteNotesBinding


class WriteNotesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWriteNotesBinding.inflate(inflater)
        val args = arguments?.let { WriteNotesFragmentArgs.fromBundle(it) }
        val id = args?.notesId ?:1
        val application = this.activity!!.application
        val notesDatabaseDao = NotesDatabase.getDatabase(application).notesDao()
        val notesRepository = NotesRepository(notesDatabaseDao)
        val viewModelFactory = WriteNotesViewModelFactory( notesRepository.notesDao,id,application)
        val writeNotesViewModel = ViewModelProviders.of(this,viewModelFactory).get(WriteNotesViewModel::class.java)
        writeNotesViewModel.notesData.observe(viewLifecycleOwner, Observer {
            notesData ->
            run {
                binding.writeText.text.append(notesData.text)
            }

        })
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(context,"destroyed",Toast.LENGTH_SHORT).show()
    }
}