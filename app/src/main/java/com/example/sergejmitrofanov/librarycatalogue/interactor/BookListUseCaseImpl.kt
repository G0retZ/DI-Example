package com.example.sergejmitrofanov.librarycatalogue.interactor

import javax.inject.Inject

class BookListUseCaseImpl @Inject constructor(
    private val booksSource: BooksSource,
    private val bookListSorter: BookListSorter
) : BookListUseCase {
    override fun getBooks() = bookListSorter.sortBooks(booksSource.getBooks())
}
