package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.notekeeper.databinding.ActivityNoteListBinding
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.onTransformationStartContainer

class NoteListActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bind:ActivityNoteListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer() // should be called before super.onCreate().
        super.onCreate(savedInstanceState)
        bind = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.fab.setOnClickListener(this)
        bind.notesList.adapter = ArrayAdapter<NoteInfo>(this, android.R.layout.simple_list_item_1, DataManager.notes)
        bind.notesList.setOnItemClickListener{parent,position, view, id ->
            val startActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(startActivityIntent)
        }

    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, MainActivity::class.java)
        TransformationCompat.startActivity(bind.transform, intent)
    }
}