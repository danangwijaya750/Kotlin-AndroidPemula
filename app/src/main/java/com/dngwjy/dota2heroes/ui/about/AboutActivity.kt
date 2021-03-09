package com.dngwjy.dota2heroes.ui.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dngwjy.dota2heroes.R
import com.dngwjy.dota2heroes.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding:ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load(resources.getDrawable(R.drawable.pp))
            .circleCrop()
            .into(binding.ivProfile)
    }
}