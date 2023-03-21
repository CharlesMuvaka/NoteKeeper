package com.example.notekeeper.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.DataManager
import com.example.notekeeper.adapters.BooksRecAdapter
import com.example.notekeeper.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    private lateinit var bind:FragmentNotesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentNotesBinding.inflate(layoutInflater)

        val books = DataManager.books
        val adp = BooksRecAdapter(requireContext())
        adp.asyncList.submitList(books)
        bind.recView.apply {
            adapter = adp
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        return bind.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotesFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}