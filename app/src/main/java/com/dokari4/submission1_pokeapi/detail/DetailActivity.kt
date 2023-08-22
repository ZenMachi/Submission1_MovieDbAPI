package com.dokari4.submission1_pokeapi.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dokari4.submission1_pokeapi.R.drawable.baseline_favorite_filled_24
import com.dokari4.submission1_pokeapi.R.drawable.baseline_favorite_unfilled_24
import com.dokari4.submission1_pokeapi.core.domain.model.Movie
import com.dokari4.submission1_pokeapi.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        @Suppress("DEPRECATION")
        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)


        showDetail(detailMovie)
    }

    private fun showDetail(detailMovie: Movie?) {
        detailMovie?.let {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/original${detailMovie.posterPath}")
                .into(binding.imgMovie)

            binding.tvMovieName.text = detailMovie.title
            binding.tvMovieOverview.text = detailMovie.overview
            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fabFav.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

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

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFav.setImageDrawable(ContextCompat.getDrawable(this, baseline_favorite_filled_24)) }
        else {
            binding.fabFav.setImageDrawable(ContextCompat.getDrawable(this, baseline_favorite_unfilled_24)) }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

}