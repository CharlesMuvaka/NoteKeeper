package com.example.notekeeper.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.DataManager
import com.example.notekeeper.MainActivity
import com.example.notekeeper.R
import com.example.notekeeper.adapters.BooksRecAdapter
import com.example.notekeeper.adapters.NotesRecAdapter
import com.example.notekeeper.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var bind:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentHomeBinding.inflate(layoutInflater)
        var adp: NotesRecAdapter? = context?.let { NotesRecAdapter(it, DataManager.books) }
        bind.recView.adapter = adp
        bind.recView.layoutManager = GridLayoutManager(requireContext(), 2)

        bind.transform.startTransformWithDelay(200)
        bind.transform.bindTargetView(bind.card)
        bind.transform.startTransform(container!!)
        bind.transform.finishTransformWithDelay(200)

        val bookAdapter = BooksRecAdapter(requireContext())
        bookAdapter.asyncList.submitList(DataManager.books)
        bind.myRecView.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(requireContext())

        }

        bind.fab.setOnClickListener{
            bind.transform.startTransform()
            bind.recView.alpha = 0.2F
            bind.recView.isClickable = false

        }

        bind.card.setOnClickListener{
            bind.transform.finishTransform()
        }
        return bind.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}