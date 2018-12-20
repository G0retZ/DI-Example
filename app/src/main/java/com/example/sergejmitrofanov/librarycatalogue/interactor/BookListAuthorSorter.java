package com.example.sergejmitrofanov.librarycatalogue.interactor;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookListAuthorSorter implements BookListSorter {

  @SuppressWarnings("ComparatorCombinators")
  @NonNull
  @Override
  public List<Book> sortBooks(@NonNull List<Book> books) {
    List<Book> sortedBooks = new ArrayList<>(books);
    Collections.sort(sortedBooks, (o1, o2) -> o1.author.compareTo(o2.author));
    return sortedBooks;
  }
}
