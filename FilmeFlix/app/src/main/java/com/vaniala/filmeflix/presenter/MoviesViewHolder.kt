package com.vaniala.filmeflix.presenter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.vaniala.filmeflix.R

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    val movieTitle = itemView.findViewById<AppCompatTextView>(R.id.movie_title)
    val movieImage = itemView.findViewById<AppCompatImageView>(R.id.movie_image)
}
