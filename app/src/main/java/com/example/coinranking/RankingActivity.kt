package com.example.coinranking

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinranking.adapters.CoinsAdapter
import com.example.coinranking.databinding.ActivityRankingBinding
import com.example.coinranking.viewmodels.NetworkStatus
import com.example.coinranking.viewmodels.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingActivity : AppCompatActivity() {

    private val rankingViewModel: RankingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coinsAdapter = CoinsAdapter()

        binding.apply {
            viewModel = rankingViewModel
            lifecycleOwner = this@RankingActivity

            rvCoinRanking.apply {
                adapter = coinsAdapter
                layoutManager = LinearLayoutManager(
                    this@RankingActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(
                    DividerItemDecoration(
                        this@RankingActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        }

        subscribeUi(coinsAdapter)
    }

    private fun subscribeUi(coinAdapter: CoinsAdapter) {
        rankingViewModel.coins.observe(this) { coins ->
            coinAdapter.submitList(coins)
        }
        rankingViewModel.status.observe(this) { status ->
            if (status == NetworkStatus.ERROR) {
                Toast.makeText(this, getString(R.string.error_text), Toast.LENGTH_LONG).show()
            }
        }
    }
}