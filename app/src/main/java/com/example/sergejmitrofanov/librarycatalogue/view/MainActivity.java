package com.example.sergejmitrofanov.librarycatalogue.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.example.sergejmitrofanov.librarycatalogue.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    // Create the adapter that will return a fragment for each of the three
    // primary sections of the activity.
    SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(this);

    // Set up the ViewPager with the sections adapter.
    ViewPager2 viewPager = findViewById(R.id.container);
    viewPager.setAdapter(mSectionsPagerAdapter);
    TabLayout tabLayout = findViewById(R.id.tabs);
    new TabLayoutMediator(
            tabLayout,
            viewPager,
            (tab, position) ->
                tab.setText(getResources().getStringArray(R.array.books_sources)[position]))
        .attach();
  }

  /**
   * A {@link FragmentStateAdapter} that returns a fragment corresponding to one of the
   * sections/tabs/pages.
   */
  static class SectionsPagerAdapter extends FragmentStateAdapter {

    SectionsPagerAdapter(FragmentActivity fm) {
      super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
      // getItem is called to instantiate the fragment for the given page.
      switch (position % 3) {
        case 0:
          return new FavoriteBooksFragment();
        case 1:
          return new InternetBooksFragment();
        case 2:
          return new ForbiddenBooksFragment();
      }
      return new BooksFragment();
    }

    @Override
    public int getItemCount() {
      // Show 3 total pages.
      return 3;
    }
  }
}
