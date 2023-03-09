package com.example.notekeeper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notekeeper.R
import com.example.notekeeper.databinding.FragmentLoginBinding

class LoginFragment: Fragment(), View.OnClickListener {
    private lateinit var bind: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = FragmentLoginBinding.inflate(layoutInflater)

        //setting an on click listener to the button
        bind.submit.setOnClickListener(this::onClick)

        return bind.root
    }

    override fun onClick(p0: View?) {
        if (p0 == bind.submit){
            p0.findNavController().navigate(R.id.action_loginFragment_to_bookFragment)
        }
    }
}