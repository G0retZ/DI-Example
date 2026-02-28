package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book
import javax.inject.Inject

class BookListTitleSorter @Inject constructor() : BookListSorter {
    override fun sortBooks(books: List<Book>) = books.sortedBy { it.bookTitle }
}
