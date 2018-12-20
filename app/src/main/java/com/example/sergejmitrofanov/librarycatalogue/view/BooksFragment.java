package com.example.sergejmitrofanov.librarycatalogue.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.sergejmitrofanov.librarycatalogue.R;
import java.util.Collections;

/**
 * A fragment representing a list of Items.
 */
public class BooksFragment extends Fragment {

  private SwipeRefreshLayout swipeRefreshLayout;
  private RecyclerView recyclerView;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_books_list, container, false);

    // Set the adapter
    recyclerView = view.findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

    if (view instanceof SwipeRefreshLayout) {
      swipeRefreshLayout = (SwipeRefreshLayout) view;
      swipeRefreshLayout.setOnRefreshListener(this::refresh);
    }
    swipeRefreshLayout.setRefreshing(true);
    refresh();
    return view;
  }

  private void refresh() {
    recyclerView.setVisibility(View.GONE);
    swipeRefreshLayout.postDelayed(() -> {
      swipeRefreshLayout.setRefreshing(false);
      recyclerView.setAdapter(new BooksRecyclerViewAdapter(Collections.emptyList()));
      recyclerView.setVisibility(View.VISIBLE);
    }, 2000);
  }
}
