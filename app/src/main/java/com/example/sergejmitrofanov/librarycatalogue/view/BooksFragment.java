package com.example.sergejmitrofanov.librarycatalogue.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.sergejmitrofanov.librarycatalogue.R;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter;
import com.example.sergejmitrofanov.librarycatalogue.presenter.BooksView;
import java.util.Collections;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class BooksFragment extends Fragment implements BooksView {

  private SwipeRefreshLayout swipeRefreshLayout;
  private RecyclerView recyclerView;

  private BookListPresenter bookListPresenter;

  public void setBookListPresenter(
      @NonNull BookListPresenter bookListPresenter) {
    this.bookListPresenter = bookListPresenter;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_books_list, container, false);

    // Set the adapter
    recyclerView = view.findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    recyclerView.setAdapter(new BooksRecyclerViewAdapter(Collections.emptyList()));

    if (view instanceof SwipeRefreshLayout) {
      swipeRefreshLayout = (SwipeRefreshLayout) view;
      swipeRefreshLayout.setOnRefreshListener(this::refresh);
    }
    swipeRefreshLayout.setRefreshing(true);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    swipeRefreshLayout.setRefreshing(true);
    bookListPresenter.attachView(this);
  }

  @Override
  public void onDestroyView() {
    bookListPresenter.detachView();
    super.onDestroyView();
  }

  private void refresh() {
    recyclerView.setVisibility(View.GONE);
    bookListPresenter.loadBooks();
  }

  @Override
  public void showBooks(@NonNull List<Book> books) {
    swipeRefreshLayout.setRefreshing(false);
    recyclerView.setAdapter(new BooksRecyclerViewAdapter(books));
    recyclerView.setVisibility(View.VISIBLE);
  }
}
