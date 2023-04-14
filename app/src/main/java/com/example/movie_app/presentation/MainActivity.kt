package com.example.movie_app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.movie_app.R
import com.example.movie_app.databinding.ActivityMainBinding
import com.example.movie_app.presentation.di.Injector
import com.example.movie_app.presentation.fragments.PopularTV
import com.example.movie_app.presentation.fragments.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //@Inject
    //lateinit var factory: ViewModelFactory
    //private lateinit var movieViewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
   // private lateinit var adapter: MovieAdapter

    val tabArrays = arrayOf("Movie", "TV")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //(application as Injector).createMovieSubComponent().inject(this)

        //movieViewModel = ViewModelProvider(this,factory)
          //  .get(MyViewModel::class.java)

       // initRecyclerView()

        val my_adapter = ViewPagerAdapter(
            supportFragmentManager,
            lifecycle
        )
        binding.pager.adapter = my_adapter

        //Connecting tablayout with the view pager
        TabLayoutMediator(binding.tabLayout, binding.pager){
            tab, position -> tab.text = tabArrays[position]
        }.attach()

    }

    /*private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        displayPopularMovies()
    }*/

   /* private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(this, Observer{

            if (it !=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }*/

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                movieViewModel.updateMovies()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }*/

}