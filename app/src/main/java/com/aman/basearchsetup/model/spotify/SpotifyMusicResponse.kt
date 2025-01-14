package com.aman.basearchsetup.model.spotify


import com.google.gson.annotations.SerializedName

data class SpotifyMusicResponse(
    @SerializedName("spotifyHomeData")
    val spotifyHomeData: List<SpotifyMusicData>?
)