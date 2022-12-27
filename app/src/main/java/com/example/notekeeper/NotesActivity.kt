package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notekeeper.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var bind: ActivityNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.fab.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}