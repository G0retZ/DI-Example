package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.view.FavoriteBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.ForbiddenBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.InternetBooksFragment;

public interface AppComponent {

  void inject(FavoriteBooksFragment favoriteBooksFragment);

  void inject(InternetBooksFragment internetBooksFragment);

  void inject(ForbiddenBooksFragment forbiddenBooksFragment);
}
