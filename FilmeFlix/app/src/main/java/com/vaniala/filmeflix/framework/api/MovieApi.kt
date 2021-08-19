package com.vaniala.filmeflix.framework.api

import com.vaniala.filmeflix.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>

}