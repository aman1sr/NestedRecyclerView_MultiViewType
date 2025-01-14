package com.aman.basearchsetup.model.spotify


import com.google.gson.annotations.SerializedName

data class Music(
    @SerializedName("artistName")
    val artistName: String?,
    @SerializedName("imageBanner")
    val imageBanner: String?,
    @SerializedName("musicGenre")
    val musicGenre: String?,
    @SerializedName("musicName")
    val musicName: String?
)