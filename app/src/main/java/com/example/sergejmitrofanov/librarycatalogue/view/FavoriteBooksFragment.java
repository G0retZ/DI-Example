package com.example.sergejmitrofanov.librarycatalogue.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.example.sergejmitrofanov.librarycatalogue.application.MainApplication;

public class FavoriteBooksFragment extends BooksFragment {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainApplication.getAppComponent().inject(this);
  }

}
