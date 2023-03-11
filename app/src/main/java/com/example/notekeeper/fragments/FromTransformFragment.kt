package com.example.notekeeper.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notekeeper.*
import com.example.notekeeper.databinding.FragmentFromTransfromationBinding
import com.skydoves.transformationlayout.addTransformation
import com.skydoves.transformationlayout.onTransformationStartContainer

class FromTransformFragment: Fragment() {
    private lateinit var bind: FragmentFromTransfromationBinding

    //calling the on transformation start container on the fragment to initiate the transformation.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onTransformationStartContainer()


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = FragmentFromTransfromationBinding.inflate(layoutInflater)

        return bind.root
    }



}