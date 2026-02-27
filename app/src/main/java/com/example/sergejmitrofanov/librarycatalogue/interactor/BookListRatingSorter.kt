package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

class BookListRatingSorter : BookListSorter {
    override fun sortBooks(books: List<Book>) = books.sortedWith { b1: Book, b2: Book ->
        val result = b2.rating - b1.rating
        if (result == 0) {
            b1.bookTitle.compareTo(b2.bookTitle)
        } else {
            result
        }
    }
}
