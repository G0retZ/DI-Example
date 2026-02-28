package com.example.sergejmitrofanov.librarycatalogue.di

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object PresenterModule {
    @Provides
    @ActivityScoped
    @FavoriteBooks
    fun provideFavoritePresenter(
        @FavoriteBooks useCase: BookListUseCase
    ): BookListPresenter = BookListPresenterImpl(useCase)


    @Provides
    @ActivityScoped
    @InternetBooks
    fun provideInternetPresenter(
        @InternetBooks useCase: BookListUseCase
    ): BookListPresenter = BookListPresenterImpl(useCase)

    @Provides
    @ActivityScoped
    @ForbiddenBooks
    fun provideForbiddenPresenter(
        @ForbiddenBooks useCase: BookListUseCase
    ): BookListPresenter = BookListPresenterImpl(useCase)
}
