package com.example.notekeeper

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.notekeeper.databinding.ActivityTransformBinding
import com.example.notekeeper.fragments.FromTransformFragment
import com.example.notekeeper.fragments.ToTransformFragment
import com.skydoves.transformationlayout.addTransformation
import com.skydoves.transformationlayout.onTransformationStartContainer

class TransformActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var bind: ActivityTransformBinding
    lateinit var books: ArrayList<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onTransformationStartContainer()
        bind = ActivityTransformBinding.inflate(layoutInflater)
        setContentView(bind.root)

        books = DataManager.books
        bind.transformationLayout.transitionName = "myTransitionName"


        //initialising the from transformation fragment
        val fragment = FromTransformFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(bind.frameLayout.id, fragment).commit()

        bind.fab
            .setOnClickListener(this::onClick)

    }

    override fun onClick(p0: View?) {
        val bundle = bind.transformationLayout.getBundle("TransformationParams")
        val fragment = ToTransformFragment()
        bundle.putSerializable("book", books[0])
        fragment.arguments = bundle

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction().addTransformation(bind.transformationLayout)
        transaction.replace(bind.frameLayout.id, fragment).commit()

    }
}