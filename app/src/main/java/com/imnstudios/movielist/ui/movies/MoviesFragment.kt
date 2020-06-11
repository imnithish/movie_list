package com.imnstudios.movielist.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.imnstudios.movielist.R
import com.imnstudios.movielist.data.models.Movie
import com.imnstudios.movielist.data.network.MoviesApi
import com.imnstudios.movielist.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repository =
            MoviesRepository(api)
        factory =
            MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MoviesAdapter(movies, this)
            }

        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when (view.id) {
            R.id.button_book -> {
                Toast.makeText(requireContext(), "button_book", Toast.LENGTH_SHORT).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "layout_like", Toast.LENGTH_SHORT).show()
            }
        }
    }
}