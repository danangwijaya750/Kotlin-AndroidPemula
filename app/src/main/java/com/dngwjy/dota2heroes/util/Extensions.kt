package com.dngwjy.dota2heroes.util

import android.content.Context
import com.dngwjy.dota2heroes.data.Hero
import com.dngwjy.dota2heroes.data.Heroes
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

fun Context.readData(id:Int):List<Hero>{
    val inStream=this.resources.openRawResource(id)
    val bufferedReader= BufferedReader(InputStreamReader(inStream))
    val read=bufferedReader.use { it.readText() }
    val data = Gson().fromJson(read, Heroes::class.java)
    bufferedReader.close()
    return data.heroes
}