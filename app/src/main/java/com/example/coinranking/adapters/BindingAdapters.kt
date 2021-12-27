package com.example.coinranking.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("iconUrl")
fun ImageView.iconUrl(iconUrl: String) {
    Glide
        .with(this)
        .load(iconUrl)
        .fitCenter()
        .into(this)
}