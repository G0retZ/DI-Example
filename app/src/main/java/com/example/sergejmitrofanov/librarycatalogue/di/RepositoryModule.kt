package com.example.sergejmitrofanov.librarycatalogue.di

import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    @FavoriteBooks
    abstract fun bindFavoriteSource(impl: FavoritesBooksSource): BooksSource

    @Binds
    @InternetBooks
    abstract fun bindInternetSource(impl: NetworkBooksSource): BooksSource

    @Binds
    @ForbiddenBooks
    abstract fun bindForbiddenSource(impl: DarkNetBooksSource): BooksSource
}
