package com.example.notekeeper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.notekeeper.Book
import com.example.notekeeper.databinding.FragmentSingleBookBinding

class SingleBokFragment: Fragment() {
    private lateinit var bind: FragmentSingleBookBinding
    private val navArgs: SingleBokFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = FragmentSingleBookBinding.inflate(layoutInflater)

        //getting the book from the navigation graph
        val book = navArgs.book

        //binding the scholar data
        bindBookData(bind, book)
        return bind.root
    }

    private fun bindBookData(bind: FragmentSingleBookBinding, book: Book) {
        bind.image.setImageResource(book.imageURL!!)
        bind.title.text = book.title
        bind.description.text = book.description
    }

}