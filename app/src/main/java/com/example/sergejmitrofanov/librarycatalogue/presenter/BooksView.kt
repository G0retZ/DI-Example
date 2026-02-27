package com.example.sergejmitrofanov.librarycatalogue.presenter;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.List;

public interface BooksView {

  void showBooks(@NonNull List<Book> books);
}
