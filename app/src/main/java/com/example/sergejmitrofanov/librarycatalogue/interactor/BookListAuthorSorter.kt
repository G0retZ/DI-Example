package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book
import javax.inject.Inject

class BookListAuthorSorter @Inject constructor() : BookListSorter {
    override fun sortBooks(books: List<Book>) = books.sortedWith { b1: Book, b2: Book ->
        val result = b1.author.compareTo(b2.author)
        if (result == 0) {
            b1.bookTitle.compareTo(b2.bookTitle)
        } else {
            result
        }
    }
}
