package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl;
import com.example.sergejmitrofanov.librarycatalogue.view.FavoriteBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.ForbiddenBooksFragment;
import com.example.sergejmitrofanov.librarycatalogue.view.InternetBooksFragment;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
@Module(includes = InteractorModule.class)
class PresenterModule {

  @Provides
  @IntoMap
  @ClassKey(FavoriteBooksFragment.class)
  BookListPresenter provideFavoriteBookListPresenter(Map<Integer, BookListUseCase> bookListUseCaseMap) {
    return new BookListPresenterImpl(bookListUseCaseMap.get(0));
  }

  @Provides
  @IntoMap
  @ClassKey(InternetBooksFragment.class)
  BookListPresenter provideInternetBookListPresenter(Map<Integer, BookListUseCase> bookListUseCaseMap) {
    return new BookListPresenterImpl(bookListUseCaseMap.get(1));

  }

  @Provides
  @IntoMap
  @ClassKey(ForbiddenBooksFragment.class)
  BookListPresenter provideForbiddenBookListPresenter(Map<Integer, BookListUseCase> bookListUseCaseMap) {
    return new BookListPresenterImpl(bookListUseCaseMap.get(2));

  }
}
