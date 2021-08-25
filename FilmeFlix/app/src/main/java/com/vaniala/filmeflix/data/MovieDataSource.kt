package com.vaniala.filmeflix.data

import com.vaniala.filmeflix.domain.Movie

interface MovieDataSource {
    fun getAllMovies(): List<Movie>
}