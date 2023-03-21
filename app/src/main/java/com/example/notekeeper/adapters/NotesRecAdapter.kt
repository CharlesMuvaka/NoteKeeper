package com.example.notekeeper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.*
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout

class NotesRecAdapter(private val context: Context, private val notes:ArrayList<Book>): RecyclerView.Adapter<NotesRecAdapter.ViewHolder>() {
    private val inflator = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.author)
        val layout = itemView.findViewById<TransformationLayout>(R.id.transformationLayout)
        var viewPosition = 0

        fun setClickListener(note: Book){
            itemView.setOnClickListener{
                val startActivity = Intent(context, ToTransformActivity::class.java)
                startActivity.putExtra("position", viewPosition)
                startActivity.putExtra("book", note.title)
                TransformationCompat.startActivity(layout, startActivity)
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflator.inflate(R.layout.book_rec, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        val authorNames = note.author.split(" ")
        holder.title.text = note.title
        holder.description.text = if(note.author.length > 17) "${authorNames[0].subSequence(0,1)}. ${authorNames[1]}" else note.author
        holder.image.setImageResource(note.imageURL!!)
        holder.viewPosition = position

        holder.setClickListener(note)

    }

    override fun getItemCount() = notes.size
}