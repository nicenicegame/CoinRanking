package com.example.coinranking.data

import com.example.coinranking.api.CoinRankingService
import javax.inject.Inject

class CoinRankingRepository @Inject constructor(
    private val coinRankingService: CoinRankingService
) {

    suspend fun getCoinRankingList(): List<Coin> {
        val response = coinRankingService.getCoinRanking()
        return response.data.coins
    }
}