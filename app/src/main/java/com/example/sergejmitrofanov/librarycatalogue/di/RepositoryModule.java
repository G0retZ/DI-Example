package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

@Module
class RepositoryModule {

  @Provides
  @IntoMap
  @IntKey(0)
  BooksSource provideFavoriteBooksSource(FavoritesBooksSource booksSource) {
    return booksSource;
  }

  @Provides
  @IntoMap
  @IntKey(1)
  BooksSource provideInternetBooksSource(NetworkBooksSource booksSource) {
    return booksSource;
  }

  @Provides
  @IntoMap
  @IntKey(2)
  BooksSource provideForbiddenBooksSource(DarkNetBooksSource booksSource) {
    return booksSource;
  }
}
