package com.example.sergejmitrofanov.librarycatalogue.presenter;

import androidx.annotation.NonNull;

public interface BookListPresenter {

  void attachView(@NonNull BooksView booksView);

  void detachView();

  void loadBooks();
}
