package com.aman.basearchsetup.utils

import android.content.Context
import android.widget.ImageView
import com.aman.basearchsetup.R
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Util {
    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
    inline fun <reified T> parseJsonToModel(jsonString: String): T {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<T>() {}.type)
    }

    fun ImageView.loadImage(url: String?, placeholder: Int = R.drawable.music_pl){
        Glide.with(context)
            .load(url)
            .centerCrop()
            .placeholder(placeholder)
            .error(R.drawable.music_placeholder2)
            .into(this)
    }
}