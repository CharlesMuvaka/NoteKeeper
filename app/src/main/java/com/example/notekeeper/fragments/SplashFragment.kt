package com.example.notekeeper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notekeeper.databinding.FragmentSplashBinding

class SplashFragment: Fragment() {
    private lateinit var bind: FragmentSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = FragmentSplashBinding.inflate(layoutInflater)

        return bind.root
    }
}