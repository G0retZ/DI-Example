package com.example.sergejmitrofanov.librarycatalogue.interactor;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class BookListTitleSorter implements BookListSorter {

  @Inject
  public BookListTitleSorter() {
  }

  @SuppressWarnings("ComparatorCombinators")
  @NonNull
  @Override
  public List<Book> sortBooks(@NonNull List<Book> books) {
    List<Book> sortedBooks = new ArrayList<>(books);
    Collections.sort(sortedBooks, (o1, o2) -> o1.bookTitle.compareTo(o2.bookTitle));
    return sortedBooks;
  }
}
