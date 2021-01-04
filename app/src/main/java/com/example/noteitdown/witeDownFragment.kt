package com.example.noteitdown

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class witeDownFragment : Fragment() {

    companion object {
        fun newInstance() = witeDownFragment()
    }

    private lateinit var viewModel: WiteDownViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wite_down_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WiteDownViewModel::class.java)
        // TODO: Use the ViewModel
    }

}