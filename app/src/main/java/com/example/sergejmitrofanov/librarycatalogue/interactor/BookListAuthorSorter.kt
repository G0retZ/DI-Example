package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

class BookListAuthorSorter : BookListSorter {
    override fun sortBooks(books: List<Book>) = books.sortedWith { b1: Book, b2: Book ->
        val result = b1.author.compareTo(b2.author)
        if (result == 0) {
            b1.bookTitle.compareTo(b2.bookTitle)
        } else {
            result
        }
    }
}
