package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
class RepositoryModule {

  @Provides
  @Named("FavoritesSource")
  BooksSource provideFavoriteBooksSource(FavoritesBooksSource booksSource) {
    return booksSource;
  }

  @Provides
  @Named("InternetSource")
  BooksSource provideInternetBooksSource(NetworkBooksSource booksSource) {
    return booksSource;
  }

  @Provides
  @Named("ForbiddenSource")
  BooksSource provideForbiddenBooksSource(DarkNetBooksSource booksSource) {
    return booksSource;
  }
}
