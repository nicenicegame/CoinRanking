package com.example.coinranking.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coinranking.data.Coin
import com.example.coinranking.databinding.ItemListCoinBinding

class CoinAdapter : ListAdapter<Coin, CoinAdapter.CoinViewHolder>(CoinDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            ItemListCoinBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = getItem(position)
        holder.bind(coin)
    }

    class CoinViewHolder(private val binding: ItemListCoinBinding) :
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