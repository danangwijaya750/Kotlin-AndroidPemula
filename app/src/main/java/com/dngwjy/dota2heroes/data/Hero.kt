package com.dngwjy.dota2heroes.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Heroes(
    val heroes:List<Hero>
)
@Parcelize
data class Hero(
    val agi_gain: Double,
    val attack_range: Int,
    val attack_rate: Double,
    val attack_type: String,
    val base_agi: Int,
    val base_armor: Double,
    val base_attack_max: Int,
    val base_attack_min: Int,
    val base_health: Int,
    val base_health_regen: Double,
    val base_int: Int,
    val base_mana: Int,
    val base_mana_regen: Double,
    val base_mr: Int,
    val base_str: Int,
    val cm_enabled: Boolean,
    val icon: String,
    val id: Int,
    val img: String,
    val int_gain: Double,
    val legs: Int,
    val localized_name: String,
    val move_speed: Int,
    val name: String,
    val primary_attr: String,
    val projectile_speed: Int,
    val roles: List<String>,
    val str_gain: Double,
    val turn_rate: Double
):Parcelable