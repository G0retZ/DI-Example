package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

interface BookListSorter {
    fun sortBooks(books: List<Book>): List<Book>
}
