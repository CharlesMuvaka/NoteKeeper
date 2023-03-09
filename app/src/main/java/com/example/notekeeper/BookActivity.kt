package com.example.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BookActivity : AppCompatActivity() {
    lateinit var books: ArrayList<Book>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        books = DataManager.books
    }
}