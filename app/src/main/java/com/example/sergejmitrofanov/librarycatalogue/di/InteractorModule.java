package com.example.sergejmitrofanov.librarycatalogue.di;

import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListAuthorSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListSorter;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCase;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BookListUseCaseImpl;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import java.util.Map;

@SuppressWarnings("ConstantConditions")
@Module(includes = RepositoryModule.class)
class InteractorModule {

  @Provides
  @IntoMap
  @IntKey(0)
  BookListUseCase provideFavoriteBookListUseCase(Map<Integer, BooksSource> booksSourceMap,
      Map<Integer, BookListSorter> bookListSorterMap) {
    return new BookListUseCaseImpl(booksSourceMap.get(0), bookListSorterMap.get(0));
  }

  @Provides
  @IntoMap
  @IntKey(1)
  BookListUseCase provideInteractorBookListUseCase(Map<Integer, BooksSource> booksSourceMap,
      Map<Integer, BookListSorter> bookListSorterMap) {
    return new BookListUseCaseImpl(booksSourceMap.get(1), bookListSorterMap.get(1));
  }

  @Provides
  @IntoMap
  @IntKey(2)
  BookListUseCase provideForbiddenBookListUseCase(Map<Integer, BooksSource> booksSourceMap,
      Map<Integer, BookListSorter> bookListSorterMap) {
    return new BookListUseCaseImpl(booksSourceMap.get(2), bookListSorterMap.get(2));
  }

  @Provides
  @IntoMap
  @IntKey(0)
  BookListSorter provideBookListTitleSorter(BookListAuthorSorter bookListSorter) {
    return bookListSorter;
  }

  @Provides
  @IntoMap
  @IntKey(1)
  BookListSorter provideBookListAuthorSorter(BookListAuthorSorter bookListSorter) {
    return bookListSorter;
  }

  @Provides
  @IntoMap
  @IntKey(2)
  BookListSorter provideBookListRatingSorter(BookListAuthorSorter bookListSorter) {
    return bookListSorter;
  }
}
