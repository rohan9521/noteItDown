package com.example.noteitdown.NotesDisplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteitdown.NotesDisplayFragment
import com.example.noteitdown.NotesEntity
import com.example.noteitdown.R
import kotlinx.android.synthetic.main.notes_view.view.*

class NotesADapter(private val notesDisplayFragment: NotesDisplayFragment):RecyclerView.Adapter<NoteViewHolder>() {
    var notes:List<NotesEntity> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.notes_view,parent,false)
        val notesViewHolder = NoteViewHolder(layout)
        notesViewHolder.noteTitle.setOnClickListener(){
            notesDisplayFragment.navigateToNotesFragment(notes[notesViewHolder.adapterPosition].id)
        }
        notesViewHolder.imgDelete.setOnClickListener(){
            notesDisplayFragment.notesDisplayViewModel.deleteNotes(notes[notesViewHolder.adapterPosition])
        }
        return  notesViewHolder
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.noteTitle.text = notes[position].title
    }
}

class NoteViewHolder(item: View):RecyclerView.ViewHolder(item){
    val noteTitle = item.findViewById<TextView>(R.id.textView)
    val imgDelete:ImageView = item.findViewById<ImageView>(R.id.imageView)


}