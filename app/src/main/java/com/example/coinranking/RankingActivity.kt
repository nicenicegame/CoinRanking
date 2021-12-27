package com.example.coinranking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coinranking.databinding.ActivityRankingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}