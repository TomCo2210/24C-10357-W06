package dev.tomco.a24c_10357_w03.Utilities

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.widget.ImageView
import com.bumptech.glide.Glide
import dev.tomco.a24c_10357_w06.R
import java.lang.ref.WeakReference
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class SingleSoundPlayer(context: Context) {
    private val context: Context = context.applicationContext
    private val executor: Executor = Executors.newSingleThreadExecutor()

    fun playSound(resId: Int) {
       executor.execute{
           val mediaPlayer = MediaPlayer.create(context,resId)
           mediaPlayer.isLooping = false
           mediaPlayer.setVolume(1.0f,1.0f)
           mediaPlayer.start()
           mediaPlayer.setOnCompletionListener { mp: MediaPlayer? ->
               var mpl = mp
               mpl!!.stop()
               mpl.release()
               mpl = null
           }
       }
    }
}