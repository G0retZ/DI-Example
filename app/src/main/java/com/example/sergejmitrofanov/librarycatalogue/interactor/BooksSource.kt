package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

interface BooksSource {
    fun getBooks(): List<Book>
}
