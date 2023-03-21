package com.example.notekeeper

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.notekeeper.databinding.ActivityToTransformBinding
import com.skydoves.transformationlayout.TransformationAppCompatActivity

class ToTransformActivity : TransformationAppCompatActivity() {
    private lateinit var bind: ActivityToTransformBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityToTransformBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val books = DataManager.books
        val intent = intent
        val bookTitle = intent.getStringExtra("book")

        for (book in books){
            if (bookTitle == book.title){
                bind.image.setImageResource(book.imageURL!!)
                bind.title.text = "${book.title} \n  By: ${book.author}"
                bind.description.text = book.description
                break
            }
        }



    }
}