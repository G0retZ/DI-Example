package com.example.sergejmitrofanov.librarycatalogue.presenter;

import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.List;

public interface BooksView {

  void showBooks(List<Book> books);
}
