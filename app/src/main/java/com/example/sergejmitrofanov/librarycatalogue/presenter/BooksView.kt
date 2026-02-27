package com.example.sergejmitrofanov.librarycatalogue.presenter

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

interface BooksView {
    fun showBooks(books: List<Book>)
}
