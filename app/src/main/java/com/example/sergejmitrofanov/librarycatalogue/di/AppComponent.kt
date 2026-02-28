package com.example.sergejmitrofanov.librarycatalogue.di

import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    @ActivityScoped
    fun provideTabsPresenters(
        @FavoriteBooks favoritePresenter: BookListPresenter,
        @InternetBooks internetPresenter: BookListPresenter,
        @ForbiddenBooks forbiddenPresenter: BookListPresenter
    ): List<BookListPresenter> = listOf(
        favoritePresenter,
        internetPresenter,
        forbiddenPresenter
    )
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FavoriteBooks

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class InternetBooks

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ForbiddenBooks

