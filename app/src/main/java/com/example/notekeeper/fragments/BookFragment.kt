package com.example.notekeeper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notekeeper.Book
import com.example.notekeeper.BookActivity
import com.example.notekeeper.adapters.BooksRecAdapter
import com.example.notekeeper.databinding.FragmentBookBinding

class BookFragment: Fragment() {

    private lateinit var bind: FragmentBookBinding
    private lateinit var adp: BooksRecAdapter
    private var books = ArrayList<Book>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bind = FragmentBookBinding.inflate(layoutInflater)

        books = (activity as BookActivity).books
        adp = BooksRecAdapter()
        adp.asyncList.submitList(books)

        //setting up the recycler view
        bind.recView.apply {
            adapter = adp
            layoutManager = GridLayoutManager(requireContext(),2)
        }

        return bind.root
    }
}