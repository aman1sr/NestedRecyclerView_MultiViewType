package com.aman.basearchsetup.model.spotify


import com.google.gson.annotations.SerializedName

data class SpotifyMusicData(
    @SerializedName("items")
    val items: List<Music>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("viewType")
    val viewType: Int?
)