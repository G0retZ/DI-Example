package com.example.sergejmitrofanov.librarycatalogue.di;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource;

class RepositoryModule {

  @NonNull
  BooksSource getFavoriteBooksSource() {
    return new FavoritesBooksSource();
  }

  @NonNull
  BooksSource getInternetBooksSource() {
    return new NetworkBooksSource();
  }

  @NonNull
  BooksSource getForbiddenBooksSource() {
    return new DarkNetBooksSource();
  }
}
