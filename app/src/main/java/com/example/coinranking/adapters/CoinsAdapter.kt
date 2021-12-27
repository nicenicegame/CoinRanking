package com.example.coinranking.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coinranking.data.Coin
import com.example.coinranking.databinding.ItemListCoinBinding

class CoinsAdapter : ListAdapter<Coin, CoinsAdapter.CoinsViewHolder>(CoinDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        return CoinsViewHolder(
            ItemListCoinBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        val coin = getItem(position)
        holder.bind(coin)
    }

    class CoinsViewHolder(private val binding: ItemListCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Coin) {
            binding.apply {
                coin = item
                executePendingBindings()
            }
        }
    }

}


private class CoinDiffCallback : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem == newItem
    }
}