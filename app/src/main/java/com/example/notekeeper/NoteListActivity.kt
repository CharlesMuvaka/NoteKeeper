package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.notekeeper.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bind:ActivityNoteListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.fab.setOnClickListener(this)
        bind.notesList.adapter = ArrayAdapter<NoteInfo>(this, android.R.layout.simple_list_item_1, DataManager.notes)

    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}