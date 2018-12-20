package com.example.sergejmitrofanov.librarycatalogue.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.sergejmitrofanov.librarycatalogue.application.MainApplication;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import javax.inject.Inject;
import javax.inject.Named;

public class InternetBooksFragment extends BooksFragment {

  @Inject
  @Override
  public void setBookListPresenter(
      @Named("InternetPresenter") @NonNull BookListPresenter bookListPresenter) {
    super.setBookListPresenter(bookListPresenter);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainApplication.getAppComponent().inject(this);
  }

}
