package com.example.sergejmitrofanov.librarycatalogue.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sergejmitrofanov.librarycatalogue.R
import com.example.sergejmitrofanov.librarycatalogue.entity.Book

/**
 * [RecyclerView.Adapter] that can display a [Book].
 */
internal class BooksRecyclerViewAdapter(private val mValues: List<Book>) :
    RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = mValues[position]
        holder.mAuthorView.text = book.author
        holder.mBookTitleView.text = book.bookTitle
        holder.mRating.text = book.rating.toString()
        holder.mView.isClickable = true
    }

    override fun getItemCount() = mValues.size

    internal class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mAuthorView: TextView = mView.findViewById(R.id.author)
        val mBookTitleView: TextView = mView.findViewById(R.id.book_title)
        val mRating: TextView = mView.findViewById(R.id.rating)
    }
}
