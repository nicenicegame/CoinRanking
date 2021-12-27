package com.example.coinranking

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinranking.adapters.CoinAdapter
import com.example.coinranking.databinding.ActivityRankingBinding
import com.example.coinranking.viewmodels.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingActivity : AppCompatActivity() {
    private val rankingViewModel: RankingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coinAdapter = CoinAdapter()

        binding.apply {
            viewModel = rankingViewModel
            lifecycleOwner = this@RankingActivity

            rvCoinRanking.apply {
                adapter = coinAdapter
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

        rankingViewModel.coins.observe(this) { coins ->
            coinAdapter.submitList(coins)
        }
    }
}