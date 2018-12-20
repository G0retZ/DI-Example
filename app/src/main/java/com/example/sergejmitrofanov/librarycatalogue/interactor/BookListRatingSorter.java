package com.example.sergejmitrofanov.librarycatalogue.interactor;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class BookListRatingSorter implements BookListSorter {

  @Inject
  public BookListRatingSorter() {
  }

  @NonNull
  @Override
  public List<Book> sortBooks(@NonNull List<Book> books) {
    List<Book> sortedBooks = new ArrayList<>(books);
    Collections.sort(sortedBooks, (o1, o2) -> {
      int res = o2.rating - o1.rating;
      if (res == 0) {
        return o2.author.compareTo(o1.author);
      }
      return res;
    });
    return sortedBooks;
  }
}
