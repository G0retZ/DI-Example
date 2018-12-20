package com.example.sergejmitrofanov.librarycatalogue.di;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl;

class PresenterModule {

  @NonNull
  private final InteractorModule interactorModule;

  PresenterModule() {
    this.interactorModule = new InteractorModule();
  }

  BookListPresenter getFavoriteBooksPresenter() {
    return new BookListPresenterImpl(
        interactorModule.getFavoriteBooksUseCase()
    );
  }

  BookListPresenter getInternetBooksPresenter() {
    return new BookListPresenterImpl(
        interactorModule.getInternetBooksUseCase()
    );
  }

  BookListPresenter getForbiddenBooksPresenter() {
    return new BookListPresenterImpl(
        interactorModule.getForbiddenBooksUseCase()
    );
  }
}
