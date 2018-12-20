package com.example.sergejmitrofanov.librarycatalogue.interactor;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookListRatingSorter implements BookListSorter {

  @NonNull
  @Override
  public List<Book> sortBooks(@NonNull List<Book> books) {
    List<Book> sortedBooks = new ArrayList<>(books);
    Collections.sort(sortedBooks,
        (b1, b2) -> {
          int res = b2.rating - b1.rating;
          if (res == 0) {
            return b1.bookTitle.compareTo(b2.bookTitle);
          }
          return res;
        });
    return sortedBooks;
  }
}
