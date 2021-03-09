package com.dngwjy.dota2heroes.ui.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import com.dngwjy.dota2heroes.databinding.ActivitySplashScreenBinding
import com.dngwjy.dota2heroes.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    private var handler:Handler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        handler= Handler()
        doSplash()
    }

    private fun doSplash(){
        handler?.postDelayed({
           startActivity(Intent(this,MainActivity::class.java))
           finish()
        },2000L)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler=null
    }
}