package dev.tomco.a24c_10357_w06

import android.app.Application
import dev.tomco.a24c_10357_w03.Utilities.ImageLoader

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        ImageLoader.init(this)
    }
}