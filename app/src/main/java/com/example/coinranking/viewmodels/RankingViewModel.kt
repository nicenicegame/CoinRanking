package com.example.coinranking.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinranking.data.Coin
import com.example.coinranking.data.CoinRankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val coinRankingRepository: CoinRankingRepository
) : ViewModel() {

    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = _coins

    init {
        viewModelScope.launch {
            val coinList = coinRankingRepository.getCoinRankingList()
            _coins.value = coinList
        }
    }
}