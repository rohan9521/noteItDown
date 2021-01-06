package com.example.noteitdown

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteitdown.NotesDisplay.NotesADapter
import com.example.noteitdown.databinding.FragmentNotesDisplayBinding

class NotesDisplayFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentNotesDisplayBinding.inflate(inflater,container,false)
        val application = requireNotNull( this.activity!!.application)
        val notesDao =  NotesDatabase.getDatabase(application).notesDao()
        val notesRepository = NotesRepository(notesDao)
        val notesDisplayViewModelFactory =   NotesViewModelFactory(notesRepository.notesDao,application = application)
        val notesDisplayViewModel = ViewModelProviders.of(this,notesDisplayViewModelFactory).get(NotesViewModel::class.java)
        val adapter = NotesADapter(this)
        adapter.notes = listOf<NotesEntity>()
        binding.recyclerViewNotesDisplay.adapter = adapter
        binding.recyclerViewNotesDisplay.layoutManager = LinearLayoutManager(context)

        notesDisplayViewModel.allNotes.observe(viewLifecycleOwner, Observer {
            list->
            run {
                adapter.notes = list
                adapter.notifyDataSetChanged()
            }
        })

        binding.addActionButton.setOnClickListener(){
            val notes = NotesEntity("this is a test string")
            notesDisplayViewModel.insertNotes(notes)

        }
        return binding.root
    }

    fun navigateToNotesFragment(notesId:Int){
        var action = NotesDisplayFragmentDirections.actionNotesDisplayFragmentToWriteNotesFragment(notesId)
        findNavController().navigate(action)
    }
}
