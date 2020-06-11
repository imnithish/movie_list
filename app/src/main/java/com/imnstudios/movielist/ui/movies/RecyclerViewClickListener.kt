package com.imnstudios.movielist.ui.movies

import android.view.View
import com.imnstudios.movielist.data.models.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}