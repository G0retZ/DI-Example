package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListRatingSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListTitleSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl;
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource;
import java.util.Arrays;
import java.util.List;

public class AppComponentImpl implements AppComponent {
  @Override
  public List<BookListPresenter> getTabsPresenters() {
    return Arrays.asList(
        new BookListPresenterImpl(
            new BookListUseCaseImpl(favoritesBooksSource, bookListTitleSorter)),
        new BookListPresenterImpl(
            new BookListUseCaseImpl(networkBooksSource, bookListAuthorSorter)),
        new BookListPresenterImpl(
            new BookListUseCaseImpl(darkNetBooksSource, bookListRatingSorter)));
  }

  // Sorters
  private final BookListSorter bookListTitleSorter = new BookListTitleSorter();
  private final BookListSorter bookListAuthorSorter = new BookListAuthorSorter();
  private final BookListSorter bookListRatingSorter = new BookListRatingSorter();

  // Sources
  private final BooksSource favoritesBooksSource = new FavoritesBooksSource();
  private final BooksSource networkBooksSource = new NetworkBooksSource();
  private final BooksSource darkNetBooksSource = new DarkNetBooksSource();
}
