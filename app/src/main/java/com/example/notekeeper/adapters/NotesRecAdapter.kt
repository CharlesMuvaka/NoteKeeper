package com.example.notekeeper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.MainActivity
import com.example.notekeeper.NoteInfo
import com.example.notekeeper.R

class NotesRecAdapter(private val context: Context, private val notes:List<NoteInfo>): RecyclerView.Adapter<NotesRecAdapter.ViewHolder>() {
    private val inflator = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.noteTitle)
        val description: TextView = itemView.findViewById(R.id.noteDescription)
        var viewPosition = 0

        init {
            itemView.setOnClickListener{
                val startActivity = Intent(context, MainActivity::class.java)
                startActivity.putExtra("position", viewPosition)
                context.startActivity(startActivity)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflator.inflate(R.layout.item_notes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.title.text = note.course.courseTitle
        holder.description.text = note.noteDescription
        holder.viewPosition = position

    }

    override fun getItemCount() = notes.size
}