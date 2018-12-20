package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource;

class RepositoryModule {

  BooksSource getFavoriteBooksSource() {
    return new FavoritesBooksSource();
  }

  BooksSource getInternetBooksSource() {
    return new NetworkBooksSource();
  }

  BooksSource getForbiddenBooksSource() {
    return new DarkNetBooksSource();
  }
}
