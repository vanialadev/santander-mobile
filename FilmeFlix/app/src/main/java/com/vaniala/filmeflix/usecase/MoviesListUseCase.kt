package com.vaniala.filmeflix.usecase

import com.vaniala.filmeflix.data.MovieRepository

class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}