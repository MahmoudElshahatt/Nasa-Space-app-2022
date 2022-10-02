package com.example.nasa_space_app.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.nasa_space_app.R

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Handler().postDelayed({
            val intent = Intent(this, onBoarding::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMER.toLong())
    }

    companion object {
        private const val SPLASH_TIMER = 2000
    }
}