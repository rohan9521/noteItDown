package com.example.noteitdown

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesADapter:RecyclerView.Adapter<NoteViewHolder>() {
    var notes:MutableList<NotesEntity> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val layout = LayoutInflater.from(parent.context).inflate(R.layout.notes_view,parent) as TextView
        val noteViewHolder  = NoteViewHolder(layout)
        return noteViewHolder
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        
    }
}

class NoteViewHolder(item: View):RecyclerView.ViewHolder(item){

}