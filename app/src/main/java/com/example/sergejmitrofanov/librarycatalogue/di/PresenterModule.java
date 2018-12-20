package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenterImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module(includes = InteractorModule.class)
class PresenterModule {

  @Provides
  @Named("FavoritesPresenter")
  BookListPresenter provideFavoriteBooksPresenter(
      @Named("Favorites") BookListUseCase bookListUseCase) {
    return new BookListPresenterImpl(bookListUseCase);
  }

  @Provides
  @Named("InternetPresenter")
  BookListPresenter provideInternetBooksPresenter(
      @Named("Internet") BookListUseCase bookListUseCase) {
    return new BookListPresenterImpl(bookListUseCase);
  }

  @Provides
  @Named("ForbiddenPresenter")
  BookListPresenter provideForbiddenBooksPresenter(
      @Named("Forbidden") BookListUseCase bookListUseCase) {
    return new BookListPresenterImpl(bookListUseCase);

  }
}
