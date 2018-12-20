package com.example.sergejmitrofanov.librarycatalogue.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sergejmitrofanov.librarycatalogue.R;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Book}.
 */
class BooksRecyclerViewAdapter extends
    RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder> {

  private final List<Book> mValues;

  BooksRecyclerViewAdapter(List<Book> items) {
    mValues = items;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_book, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    holder.mAuthorView.setText(mValues.get(position).author);
    holder.mBookTitleView.setText(mValues.get(position).bookTitle);
    holder.mRating.setText(String.valueOf(mValues.get(position).rating));
    holder.mView.setClickable(true);
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    final View mView;
    final TextView mAuthorView;
    final TextView mBookTitleView;
    final TextView mRating;

    ViewHolder(View view) {
      super(view);
      mView = view;
      mAuthorView = view.findViewById(R.id.author);
      mBookTitleView = view.findViewById(R.id.book_title);
      mRating = view.findViewById(R.id.rating);
    }
  }
}
