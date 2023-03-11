package com.example.notekeeper.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.notekeeper.Book
import com.example.notekeeper.databinding.FragmentToTransformBinding
import com.skydoves.transformationlayout.TransformationLayout
import com.skydoves.transformationlayout.onTransformationEndContainer

class ToTransformFragment: Fragment() {
    private lateinit var bind: FragmentToTransformBinding
    private var book:Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //getting the transformation layout params from the bundle
        val params = arguments?.getParcelable<TransformationLayout.Params>("TransformationParams")

        //calling the on transformation end container method
        onTransformationEndContainer(params)

        book = arguments?.getSerializable("book") as Book
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentToTransformBinding.inflate(layoutInflater)

        bind.root.transitionName = "myTransitionName"
        bind.image.setImageResource(book!!.imageURL!!)
        bind.title.text = book!!.title
        bind.description.text = book!!.description

    }

    companion object{
        fun newInstance(book: Book): ToTransformFragment{
            val fragment =  ToTransformFragment()
            val bundle = Bundle()
            bundle.putSerializable("book", Book::class.java)
            fragment.arguments = bundle
            return fragment
        }
    }
}