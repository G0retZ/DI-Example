package com.example.sergejmitrofanov.librarycatalogue.di

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListRatingSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListTitleSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource

val tabsPresenters: List<BookListPresenter>
    get() = listOf(
        BookListPresenterImpl(
            bookListUseCase = BookListUseCaseImpl(
                booksSource = favoriteBooksSource,
                bookListSorter = bookListTitleSorter
            )
        ),

        BookListPresenterImpl(
            bookListUseCase = BookListUseCaseImpl(
                booksSource = internetBooksSource,
                bookListSorter = bookListAuthorSorter
            )
        ), BookListPresenterImpl(
            bookListUseCase = BookListUseCaseImpl(
                booksSource = forbiddenBooksSource,
                bookListSorter = bookListRatingSorter
            )
        )
    )

// Sorters
val bookListAuthorSorter: BookListAuthorSorter = BookListAuthorSorter()
val bookListTitleSorter: BookListTitleSorter = BookListTitleSorter()
val bookListRatingSorter: BookListRatingSorter = BookListRatingSorter()

// Sources
val favoriteBooksSource: BooksSource = FavoritesBooksSource()
val internetBooksSource: BooksSource = NetworkBooksSource()
val forbiddenBooksSource: BooksSource = DarkNetBooksSource()
