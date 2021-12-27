package com.example.coinranking.data

import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("base")
    val base: String,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("order")
    val order: String,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total24hVolume")
    val total24hVolume: Double,
    @SerializedName("totalExchanges")
    val totalExchanges: Int,
    @SerializedName("totalMarketCap")
    val totalMarketCap: Double,
    @SerializedName("totalMarkets")
    val totalMarkets: Int
)