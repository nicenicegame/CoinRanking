package com.example.coinranking.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinranking.data.Coin
import com.example.coinranking.data.CoinRankingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

enum class NetworkStatus {
    LOADING,
    DONE,
    ERROR
}

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val coinRankingRepository: CoinRankingRepository
) : ViewModel() {

    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = _coins

    private val _status = MutableLiveData<NetworkStatus>()
    val status: LiveData<NetworkStatus> = _status

    init {
        viewModelScope.launch {
            _status.value = NetworkStatus.LOADING
            try {
                val coinList = coinRankingRepository.getCoinRankingList()
                _coins.value = coinList
                _status.value = NetworkStatus.DONE
            } catch (e: Exception) {
                _status.value = NetworkStatus.ERROR
                _coins.value = emptyList()
            }
        }
    }
}