package com.example.notekeeper.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notekeeper.DataManager
import com.example.notekeeper.MainActivity
import com.example.notekeeper.R
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
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentHomeBinding.inflate(layoutInflater)
        val adapter: NotesRecAdapter? = context?.let { NotesRecAdapter(it, DataManager.notes) }
        bind.recView.adapter = adapter
        bind.recView.layoutManager = LinearLayoutManager(context)

        bind.fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            context?.startActivity(intent)
        })
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