package com.example.sergejmitrofanov.librarycatalogue.interactor

class BookListUseCaseImpl(
    private val booksSource: BooksSource,
    private val bookListSorter: BookListSorter
) : BookListUseCase {
    override fun getBooks() = bookListSorter.sortBooks(booksSource.getBooks())
}
