package com.example.notekeeper.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment
import com.example.notekeeper.R
import com.example.notekeeper.databinding.FragmentSplashBinding

class SplashFragment: Fragment() {
    private lateinit var bind: FragmentSplashBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = FragmentSplashBinding.inflate(layoutInflater)

        //creating a fragment navigator extras instance to enable shared fragment animations
        val extras = FragmentNavigatorExtras(bind.image to "login_image", bind.title to "login_title")

        //creating a splash screen animation
        Handler(Looper.getMainLooper()).postDelayed({
            NavHostFragment.findNavController(this).navigate(R.id.action_splashFragment2_to_loginFragment, null, null, extras)
        },3000)

        return bind.root
    }
}