package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListRatingSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListTitleSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl;
import com.example.sergejmitrofanov.librarycatalogue.repository.DarkNetBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.FavoritesBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.repository.NetworkBooksSource;
import com.example.sergejmitrofanov.librarycatalogue.view.FavoriteBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.ForbiddenBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.InternetBooksFragment;

public class AppComponentImpl implements AppComponent {

  @Override
  public void inject(FavoriteBooksFragment favoriteBooksFragment) {
    favoriteBooksFragment.setBookListPresenter(
        new BookListPresenterImpl(
            new BookListUseCaseImpl(
                new FavoritesBooksSource(),
                new BookListTitleSorter()
            )
        )
    );
  }

  @Override
  public void inject(InternetBooksFragment internetBooksFragment) {
    internetBooksFragment.setBookListPresenter(
        new BookListPresenterImpl(
            new BookListUseCaseImpl(
                new NetworkBooksSource(),
                new BookListAuthorSorter()
            )
        )
    );
  }

  @Override
  public void inject(ForbiddenBooksFragment forbiddenBooksFragment) {
    forbiddenBooksFragment.setBookListPresenter(
        new BookListPresenterImpl(
            new BookListUseCaseImpl(
                new DarkNetBooksSource(),
                new BookListRatingSorter()
            )
        )
    );
  }
}
