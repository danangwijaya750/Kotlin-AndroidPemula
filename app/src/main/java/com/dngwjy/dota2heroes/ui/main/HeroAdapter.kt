package com.dngwjy.dota2heroes.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dngwjy.dota2heroes.R
import com.dngwjy.dota2heroes.data.Hero
import com.dngwjy.dota2heroes.databinding.ItemHeroBinding
import com.dngwjy.dota2heroes.ui.detail.DetailHeroActivity

class HeroAdapter(val data:List<Hero>):RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(ItemHeroBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int = data.size
    class HeroViewHolder(val binding:ItemHeroBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(hero: Hero){
            binding.tvHeroName.text=hero.localized_name
            binding.tvHeroAbility.text="Primary Attr : ${hero.primary_attr}"
            binding.tvHeroAttack.text="Attack type : ${hero.attack_type}"
            val src=when(hero.primary_attr){
                "agi"->R.drawable.agi
                "str"->R.drawable.str
                else->R.drawable.intl
            }
            Glide.with(itemView).load(itemView.context.resources.getDrawable(src)).into(binding.ivAttr)
            Glide.with(itemView).load("http://cdn.dota2.com${hero.icon}").into(binding.ivIcon)
            binding.tvHeroRoles.text="Roles : "
            hero.roles.forEach {
                binding.tvHeroRoles.text=binding.tvHeroRoles.text.toString()+"#$it" }
            itemView.setOnClickListener {
                val intent=Intent(it.context,DetailHeroActivity::class.java)
                intent.putExtra("data",hero)
                it.context.startActivity(intent)
            }
        }
    }
}