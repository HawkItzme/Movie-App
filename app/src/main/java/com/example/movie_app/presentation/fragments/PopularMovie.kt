package com.example.movie_app.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie_app.R
import com.example.movie_app.databinding.FragmentPopularMovieBinding
import com.example.movie_app.presentation.MovieAdapter
import com.example.movie_app.presentation.MyViewModel
import com.example.movie_app.presentation.ViewModelFactory
import com.example.movie_app.presentation.di.Injector
import javax.inject.Inject

class PopularMovie : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: MyViewModel
    private lateinit var binding: FragmentPopularMovieBinding
    private lateinit var my_adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_popular_movie, container, false)
        setHasOptionsMenu(true)
        val binding = FragmentPopularMovieBinding.inflate(inflater,container,false)
        (requireContext().applicationContext as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory).get(MyViewModel::class.java)
        initRecyclerView()

        return  binding.root

    }

    private fun initRecyclerView() {
        val manager : LinearLayoutManager = LinearLayoutManager(context)
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        my_adapter = MovieAdapter()
        //binding.recyclerView.adapter = my_adapter
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.hasFixedSize()
        binding.recyclerView.adapter = my_adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(viewLifecycleOwner, Observer{
            if (it !=null){
                my_adapter.setList(it)
                Log.d("APIRes", it.toString())
                my_adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    public fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it!= null){
                my_adapter.setList(it)
                my_adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = inflater
        inflater.inflate(R.menu.update,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                movieViewModel.updateMovies()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}