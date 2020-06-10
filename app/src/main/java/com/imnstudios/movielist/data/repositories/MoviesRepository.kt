package com.imnstudios.movielist.data.repositories

import com.imnstudios.movielist.data.network.MoviesApi

class MoviesRepository(
    private val api: MoviesApi

) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}