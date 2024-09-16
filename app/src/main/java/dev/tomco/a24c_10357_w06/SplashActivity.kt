package dev.tomco.a24c_10357_w06

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import dev.tomco.a24c_10357_w03.Utilities.BackgroundMusicPlayer
import dev.tomco.a24c_10357_w06.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        startAnimation(binding.splashLOTTIELottie)

    }

    override fun onResume() {
        super.onResume()
        BackgroundMusicPlayer.getInstance().startMusic()
    }
    private fun startAnimation(lottieAnimationView: LottieAnimationView) {
        lottieAnimationView.resumeAnimation()
        lottieAnimationView.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                // go fetch data

            }

            override fun onAnimationEnd(animation: Animator) {
                transactToMainActivity()
            }

            override fun onAnimationCancel(animation: Animator) {
                //pass
            }

            override fun onAnimationRepeat(animation: Animator) {
                // check if data received
                // if true - cancel repeats
            }

        })
    }


    private fun transactToMainActivity() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}