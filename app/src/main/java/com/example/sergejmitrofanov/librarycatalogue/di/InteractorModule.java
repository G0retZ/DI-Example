package com.example.sergejmitrofanov.librarycatalogue.di;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListRatingSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListTitleSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl;

class InteractorModule {

  @NonNull
  private final RepositoryModule repositoryModule;

  InteractorModule() {
    this.repositoryModule = new RepositoryModule();
  }

  BookListUseCase getFavoriteBooksUseCase() {
    return new BookListUseCaseImpl(
        repositoryModule.getFavoriteBooksSource(),
        new BookListTitleSorter()
    );
  }

  BookListUseCase getInternetBooksUseCase() {
    return new BookListUseCaseImpl(
        repositoryModule.getInternetBooksSource(),
        new BookListAuthorSorter()
    );
  }

  BookListUseCase getForbiddenBooksUseCase() {
    return new BookListUseCaseImpl(
        repositoryModule.getForbiddenBooksSource(),
        new BookListRatingSorter()
    );
  }
}
