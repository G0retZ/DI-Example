package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

class BookListTitleSorter : BookListSorter {
    override fun sortBooks(books: List<Book>) = books.sortedBy { it.bookTitle }
}
