package com.example.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.adapters.BooksRecAdapter
import com.skydoves.transformationlayout.onTransformationStartContainer

class FromTransformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_transform)

        val books = DataManager.books
        val recView = findViewById<RecyclerView>(R.id.recView)
        val adp = BooksRecAdapter(this)
        adp.asyncList.submitList(books)

        recView.apply {
            adapter = adp
            layoutManager = GridLayoutManager(this@FromTransformActivity,2)
            setHasFixedSize(true)
        }


    }
}