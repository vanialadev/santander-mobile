package com.vaniala.filmeflix.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vaniala.filmeflix.R
import com.vaniala.filmeflix.model.Movie
import com.vaniala.filmeflix.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var moviesList: RecyclerView

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesList = findViewById(R.id.movies_list)

        movieListViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            populateList(list)
        })
    }

    private fun populateList(list: List<Movie>) {
        moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
}