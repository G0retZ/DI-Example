package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import java.util.List;

public interface AppComponent {

  List<BookListPresenter> getTabsPresenters();
}
