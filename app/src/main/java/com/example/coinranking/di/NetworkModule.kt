package com.example.coinranking.di

import com.example.coinranking.api.CoinRankingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideCoinRankingService(): CoinRankingService = CoinRankingService.create()
}