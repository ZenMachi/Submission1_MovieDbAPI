package com.dokari4.favorite2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dokari4.favorite2.databinding.ActivityFavoriteBinding
import com.dokari4.submission1_pokeapi.core.ui.MovieAdapter
import com.dokari4.submission1_pokeapi.detail.DetailActivity
import com.dokari4.submission1_pokeapi.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movieFavAdapter = MovieAdapter()
        movieFavAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favorite.observe(this) { favoriteData ->
            movieFavAdapter.setData(favoriteData)
            binding.viewEmpty.root.visibility = if (favoriteData.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvMovieFav) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = movieFavAdapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            else -> return false
        }
        return super.onOptionsItemSelected(item)
    }
}