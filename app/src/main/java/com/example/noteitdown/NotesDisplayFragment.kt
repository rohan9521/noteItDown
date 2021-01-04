package com.example.noteitdown

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.noteitdown.databinding.FragmentWiteDownTextBinding

class NotesDisplayFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FragmentWiteDownTextBinding.inflate(LayoutInflater.from(context))
    }
}
