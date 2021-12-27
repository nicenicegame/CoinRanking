package com.example.coinranking.api

import com.example.coinranking.data.RankingResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoinRankingService {

    @GET("coins")
    suspend fun getCoinRanking(): RankingResponse

    companion object {
        private const val BASE_URL = "https://api.coinranking.com/v1/public/"

        fun create() =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinRankingService::class.java)
    }
}