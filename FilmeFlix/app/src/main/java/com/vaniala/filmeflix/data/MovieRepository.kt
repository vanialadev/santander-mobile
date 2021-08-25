package com.vaniala.filmeflix.data

import com.vaniala.filmeflix.data.MovieDataSource

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()

}