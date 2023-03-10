package com.example.notekeeper.adapters

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
import com.example.notekeeper.databinding.BookRecBinding
import com.example.notekeeper.fragments.BookFragment

class BooksRecAdapter: RecyclerView.Adapter<BooksRecAdapter.MyHolder>() {

    inner class MyHolder(private val bind: BookRecBinding): RecyclerView.ViewHolder(bind.root), View.OnClickListener {
        val bundle =  Bundle()
        fun setData(book: Book){
            bind.image.setImageResource(book.imageURL!!)
            bind.title.text = book.title
            bind.author.text = book.author
            bundle.putSerializable("book", book)

            bind.root.setOnClickListener(this::onClick)
        }

        override fun onClick(p0: View?) {
            if (p0 == bind.root){
                p0.findFragment<BookFragment>().findNavController().navigate(R.id.action_bookFragment_to_singleBokFragment, bundle)
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