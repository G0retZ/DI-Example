package com.example.sergejmitrofanov.librarycatalogue.interactor

import com.example.sergejmitrofanov.librarycatalogue.entity.Book

interface BookListUseCase {
    fun getBooks(): List<Book>
}
