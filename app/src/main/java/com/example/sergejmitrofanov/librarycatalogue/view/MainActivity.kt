package com.example.sergejmitrofanov.librarycatalogue.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sergejmitrofanov.librarycatalogue.R
import com.example.sergejmitrofanov.librarycatalogue.presenter.BookListPresenter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var tabsPresenters: List<@JvmSuppressWildcards BookListPresenter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar?>(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        val mSectionsPagerAdapter = SectionsPagerAdapter(this, tabsPresenters)

        // Set up the ViewPager with the sections adapter.
        val viewPager = findViewById<ViewPager2>(R.id.container)
        viewPager.setAdapter(mSectionsPagerAdapter)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = getResources().getStringArray(R.array.books_sources)[position]
        }
            .attach()
    }

    /**
     * A [FragmentStateAdapter] that returns a fragment corresponding to one of the
     * sections/tabs/pages.
     */
    internal class SectionsPagerAdapter(
        fm: FragmentActivity,
        private val presenters: List<BookListPresenter>
    ) : FragmentStateAdapter(fm) {
        override fun createFragment(position: Int): Fragment = BooksFragment(presenters[position])
        override fun getItemCount(): Int = presenters.size
    }
}
