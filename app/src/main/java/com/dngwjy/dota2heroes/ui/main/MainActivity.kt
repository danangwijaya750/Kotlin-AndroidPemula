package com.dngwjy.dota2heroes.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.dngwjy.dota2heroes.R
import com.dngwjy.dota2heroes.data.Hero
import com.dngwjy.dota2heroes.databinding.ActivityMainBinding
import com.dngwjy.dota2heroes.ui.about.AboutActivity
import com.dngwjy.dota2heroes.util.readData

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val listHero= mutableListOf<Hero>()
    private val adapter=HeroAdapter(listHero)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateData()
        binding.rvHeroes.apply {
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
    }

    private fun populateData(){
        listHero.clear()
        listHero.addAll(readData(R.raw.hero))
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem)=when(item.itemId){
        R.id.action_about->{
            startActivity(Intent(this,AboutActivity::class.java))
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }
    }
}