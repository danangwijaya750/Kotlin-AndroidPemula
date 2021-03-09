package com.dngwjy.dota2heroes.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dngwjy.dota2heroes.R
import com.dngwjy.dota2heroes.data.Hero
import com.dngwjy.dota2heroes.databinding.ActivityDetailHeroBinding

class DetailHeroActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showData()
    }
    private fun showData(){
        val data = intent.getParcelableExtra<Hero>("data") as Hero
        Glide.with(this).load("http://cdn.dota2.com${data.img}").centerCrop()
            .into(binding.ivHero)
        binding.tvHeroName.text=data.localized_name
        binding.tvHeroAbility.text="Primari Attr : ${data.primary_attr}"
        binding.tvHeroAttack.text="Attack Type : ${data.attack_type}"
        val src=when(data.primary_attr){
            "agi"->R.drawable.agi
            "str"->R.drawable.str
            else->R.drawable.intl
        }
        Glide.with(this).load(resources.getDrawable(src)).into(binding.ivAttr)
        binding.tvHeroRoles.text="Roles :"
        data.roles.forEach {
            binding.tvHeroRoles.text=binding.tvHeroRoles.text.toString()+" #$it" }
        binding.tvBaseAttr.text="Base Strength : ${data.base_str}\n" +
                "Base Agiltiy : ${data.base_agi}\n" +
                "Base Intelligence : ${data.base_int}"
    }
}