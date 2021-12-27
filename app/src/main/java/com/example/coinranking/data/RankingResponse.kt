package com.example.coinranking.data

import com.google.gson.annotations.SerializedName

data class RankingResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("status")
    val status: String
)