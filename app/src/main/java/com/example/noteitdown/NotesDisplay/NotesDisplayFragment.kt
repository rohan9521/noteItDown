package com.example.noteitdown

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.noteitdown.databinding.FragmentNotesDisplayBinding

class NotesDisplayFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentNotesDisplayBinding.inflate(inflater,container,false)
        return binding.root
    }
}
