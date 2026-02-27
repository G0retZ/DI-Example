package com.example.sergejmitrofanov.librarycatalogue.interactor;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.List;

public interface BooksSource {

  @NonNull
  List<Book> getBooks();
}
