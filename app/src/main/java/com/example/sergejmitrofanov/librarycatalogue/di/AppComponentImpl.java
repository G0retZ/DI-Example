package com.example.sergejmitrofanov.librarycatalogue.di;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.view.FavoriteBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.ForbiddenBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.InternetBooksFragment;

public class AppComponentImpl implements AppComponent {

  @NonNull
  private final PresenterModule presenterModule;

  public AppComponentImpl() {
    this.presenterModule = new PresenterModule();
  }

  @Override
  public void inject(FavoriteBooksFragment favoriteBooksFragment) {
    favoriteBooksFragment.setBookListPresenter(
        presenterModule.getFavoriteBooksPresenter()
    );
  }

  @Override
  public void inject(InternetBooksFragment internetBooksFragment) {
    internetBooksFragment.setBookListPresenter(
        presenterModule.getInternetBooksPresenter()
    );
  }

  @Override
  public void inject(ForbiddenBooksFragment forbiddenBooksFragment) {
    forbiddenBooksFragment.setBookListPresenter(
        presenterModule.getForbiddenBooksPresenter()
    );
  }
}
