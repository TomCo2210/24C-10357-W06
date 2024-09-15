package dev.tomco.a24c_10357_w06.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.tomco.a24c_10357_w03.Utilities.ImageLoader
import dev.tomco.a24c_10357_w03.Utilities.TimeFormatter
import dev.tomco.a24c_10357_w06.R
import dev.tomco.a24c_10357_w06.databinding.HorizontalMovieItemBinding
import dev.tomco.a24c_10357_w06.interfaces.MovieCallback
import dev.tomco.a24c_10357_w06.models.Movie
import java.time.format.DateTimeFormatter

class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieCallback: MovieCallback? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = HorizontalMovieItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun getItem(position: Int) = movies.get(position)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(holder) {
            with(movies.get(position)) {
                binding.movieLBLTitle.text = name
                binding.movieLBLYear.text =
                    releaseDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")).toString()
                binding.movieLBLDuration.text = TimeFormatter.formatTime(length)
                binding.movieLBLGenres.text = genre.joinToString(", ")
                binding.movieLBLActors.text = actors.joinToString(", ")
                binding.movieLBLOverview.text = overview
                binding.moveRTNGRating.rating = rating / 2
                ImageLoader.getInstance().load(poster, binding.movieIMGPoster)
                if (isFavorite) binding.movieIMGFavorite.setImageResource(R.drawable.heart)
                else binding.movieIMGFavorite.setImageResource(R.drawable.empty_heart)

            }
        }
    }

    inner class MovieViewHolder(val binding: HorizontalMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.movieIMGFavorite.setOnClickListener { v: View ->
                if (movieCallback != null)
                    movieCallback!!.favoriteButtonClicked(
                        getItem(adapterPosition),
                        adapterPosition
                    )
            }
        }
    }
}