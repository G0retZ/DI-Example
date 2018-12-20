package com.example.sergejmitrofanov.librarycatalogue.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.sergejmitrofanov.librarycatalogue.application.MainApplication;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import java.util.Map;
import javax.inject.Inject;

public class FavoriteBooksFragment extends BooksFragment {

  @SuppressWarnings("ConstantConditions")
  @Inject
  public void setBookListPresenter(@NonNull Map<Class<?>, BookListPresenter> bookListPresenter) {
    super.setBookListPresenter(bookListPresenter.get(getClass()));
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainApplication.getAppComponent().inject(this);
  }

}
