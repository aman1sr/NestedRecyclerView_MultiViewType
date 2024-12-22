package com.aman.basearchsetup.model


import com.google.gson.annotations.SerializedName

data class TopHeadlinesResponse(
    @SerializedName("articles")
    val articles: List<Article?>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)