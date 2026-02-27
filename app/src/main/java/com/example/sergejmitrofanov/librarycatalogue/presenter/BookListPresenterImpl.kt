package com.example.sergejmitrofanov.librarycatalogue.presenter

import android.os.Handler
import android.os.Looper
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase

class BookListPresenterImpl(private val bookListUseCase: BookListUseCase) : BookListPresenter {
    private var booksView: BooksView? = null

    override fun attachView(booksView: BooksView) {
        this.booksView = booksView
        loadBooks()
    }

    override fun detachView() {
        this.booksView = null
    }

    override fun loadBooks() {
        Handler(Looper.getMainLooper()).postDelayed(
            { booksView?.showBooks(bookListUseCase.getBooks()) },
            2000,
        )
    }
}
