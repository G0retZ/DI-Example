package com.example.sergejmitrofanov.librarycatalogue.di

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListRatingSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListTitleSorter
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class InteractorModule {

    @Binds
    @FavoriteBooks
    abstract fun bindFavoriteSorter(impl: BookListTitleSorter): BookListSorter

    @Binds
    @InternetBooks
    abstract fun bindInternetSorter(impl: BookListAuthorSorter): BookListSorter

    @Binds
    @ForbiddenBooks
    abstract fun bindForbiddenSorter(impl: BookListRatingSorter): BookListSorter

    companion object {
        @Provides
        @ActivityScoped
        @FavoriteBooks
        fun provideFavoriteUseCase(
            @FavoriteBooks source: BooksSource,
            @FavoriteBooks sorter: BookListSorter
        ): BookListUseCase = BookListUseCaseImpl(source, sorter)

        @Provides
        @ActivityScoped
        @InternetBooks
        fun provideInternetUseCase(
            @InternetBooks source: BooksSource,
            @InternetBooks sorter: BookListSorter
        ): BookListUseCase = BookListUseCaseImpl(source, sorter)

        @Provides
        @ActivityScoped
        @ForbiddenBooks
        fun provideForbiddenUseCase(
            @ForbiddenBooks source: BooksSource,
            @ForbiddenBooks sorter: BookListSorter
        ): BookListUseCase = BookListUseCaseImpl(source, sorter)
    }
}
