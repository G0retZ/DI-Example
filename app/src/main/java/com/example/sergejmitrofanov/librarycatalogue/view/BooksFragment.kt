package com.example.sergejmitrofanov.librarycatalogue.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.sergejmitrofanov.librarycatalogue.R
import com.example.sergejmitrofanov.librarycatalogue.entity.Book
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter
import com.example.sergejmitrofanov.librarycatalogue.presenter.BooksView

/**
 * A fragment representing a list of Items.
 */
class BooksFragment(private val presenter: BookListPresenter) : Fragment(), BooksView {
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_books_list, container, false)

        // Set the adapter
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.setLayoutManager(LinearLayoutManager(context))
        recyclerView?.setAdapter(BooksRecyclerViewAdapter(mutableListOf()))

        if (view is SwipeRefreshLayout) {
            swipeRefreshLayout = view
            swipeRefreshLayout?.setOnRefreshListener { this.refresh() }
        }
        swipeRefreshLayout?.isRefreshing = true
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeRefreshLayout?.isRefreshing = true
        presenter.attachView(this)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    private fun refresh() {
        recyclerView?.visibility = View.GONE
        presenter.loadBooks()
    }

    override fun showBooks(books: List<Book>) {
        swipeRefreshLayout?.isRefreshing = false
        recyclerView?.setAdapter(BooksRecyclerViewAdapter(books))
        recyclerView?.visibility = View.VISIBLE
    }
}
