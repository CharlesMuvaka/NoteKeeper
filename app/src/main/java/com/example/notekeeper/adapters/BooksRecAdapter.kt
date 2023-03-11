package com.example.notekeeper.adapters

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.Book
import com.example.notekeeper.R
import com.example.notekeeper.ToTransformActivity
import com.example.notekeeper.databinding.BookRecBinding
import com.example.notekeeper.fragments.BookFragment
import com.example.notekeeper.fragments.DialogFragment
import com.example.notekeeper.fragments.SingleBokFragment
import com.example.notekeeper.fragments.ToTransformFragment
import com.skydoves.transformationlayout.TransformationCompat

class BooksRecAdapter(val cont: Context): RecyclerView.Adapter<BooksRecAdapter.MyHolder>() {

    inner class MyHolder(private val bind: BookRecBinding): RecyclerView.ViewHolder(bind.root) {
        val bundle =  Bundle()
        fun setData(book: Book){
            bind.image.setImageResource(book.imageURL!!)
            bind.title.text = book.title
            val author = book.author.split(" ")
            if (author[0].length > 6){
                bind.author.text = "${author[0].subSequence(0,1)}. ${author[1]}"
            }else{
                bind.author.text = book.author
            }
            bundle.putSerializable("book", book)

            bind.root.setOnClickListener{
                //val intent = Intent(cont, ToTransformActivity::class.java)
                //intent.putExtra("book", book.title)
                //TransformationCompat.startActivity(bind.transformationLayout, intent)

                //getting the bundle from the transformation layout
                val bundle = bind.transformationLayout.getBundle("TransformationParams")

                //initiating the fragment to transform into
                val fragment = ToTransformFragment.newInstance(book)

                val parentFragment = bind.root.findFragment<BookFragment>()
               //parentFragment.

            }
        }

    }

    private val diffUtil = object: DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }

    val asyncList = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyHolder(
        BookRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(asyncList.currentList[position])
    }

    override fun getItemCount() = asyncList.currentList.size
}