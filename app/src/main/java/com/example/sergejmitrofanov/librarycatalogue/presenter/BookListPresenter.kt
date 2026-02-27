package com.example.sergejmitrofanov.librarycatalogue.presenter

interface BookListPresenter {
    fun attachView(booksView: BooksView)

    fun detachView()

    fun loadBooks()
}
