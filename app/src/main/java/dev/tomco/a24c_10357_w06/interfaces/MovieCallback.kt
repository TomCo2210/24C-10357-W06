package dev.tomco.a24c_10357_w06.interfaces

import dev.tomco.a24c_10357_w06.models.Movie

interface MovieCallback {
    fun favoriteButtonClicked(movie: Movie, position: Int)
}