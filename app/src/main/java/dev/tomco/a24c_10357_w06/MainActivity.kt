package dev.tomco.a24c_10357_w06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.tomco.a24c_10357_w06.adapters.MovieAdapter
import dev.tomco.a24c_10357_w06.databinding.ActivityMainBinding
import dev.tomco.a24c_10357_w06.interfaces.MovieCallback
import dev.tomco.a24c_10357_w06.models.Movie
import dev.tomco.a24c_10357_w06.utilities.DataManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var movieAdapter = MovieAdapter(DataManager.generateMovieList())
        movieAdapter.movieCallback  = object : MovieCallback {
            override fun favoriteButtonClicked(movie: Movie, position: Int) {
                movie.isFavorite = !movie.isFavorite
                movieAdapter.notifyItemChanged(position)
            }
        }
        binding.mainRVList.adapter = movieAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        binding.mainRVList.layoutManager = linearLayoutManager

    }
}