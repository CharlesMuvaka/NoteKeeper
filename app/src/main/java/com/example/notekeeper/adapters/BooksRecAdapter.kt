package com.example.notekeeper.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.Book
import com.example.notekeeper.databinding.BookRecBinding

class BooksRecAdapter: RecyclerView.Adapter<BooksRecAdapter.MyHolder>() {

    inner class MyHolder(private val bind: BookRecBinding): RecyclerView.ViewHolder(bind.root) {
        fun setData(book: Book){
            bind.title.text = book.title
            bind.author.text = book.author
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