package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListRatingSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListTitleSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module(includes = RepositoryModule.class)
class InteractorModule {

  @Provides
  @Named("Favorites")
  BookListUseCase provideFavoriteBooksUseCase(
      BookListTitleSorter bookListSorter,
      @Named("FavoritesSource") BooksSource booksSource) {
    return new BookListUseCaseImpl(booksSource, bookListSorter);
  }

  @Provides
  @Named("Internet")
  BookListUseCase provideInternetBooksUseCase(
      BookListAuthorSorter bookListSorter,
      @Named("InternetSource") BooksSource booksSource) {
    return new BookListUseCaseImpl(booksSource, bookListSorter);
  }

  @Provides
  @Named("Forbidden")
  BookListUseCase provideForbiddenBooksUseCase(
      BookListRatingSorter bookListSorter,
      @Named("ForbiddenSource") BooksSource booksSource
  ) {
    return new BookListUseCaseImpl(booksSource, bookListSorter);
  }
}
