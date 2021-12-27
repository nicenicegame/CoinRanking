package com.example.coinranking.adapters

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.coinranking.R
import com.example.coinranking.viewmodels.NetworkStatus

@BindingAdapter("iconUrl")
fun ImageView.iconUrl(iconUrl: String) {
    Glide
        .with(this)
        .load(iconUrl)
        .fitCenter()
        .error(R.drawable.ic_broken_image)
        .thumbnail(0.25f)
        .into(this)
}

@BindingAdapter("isLoading")
fun ProgressBar.bindIsLoading(status: NetworkStatus) {
    when (status) {
        NetworkStatus.LOADING -> this.visibility = View.VISIBLE
        NetworkStatus.DONE -> this.visibility = View.GONE
        else -> this.visibility = View.GONE
    }
}

@BindingAdapter("networkStatus")
fun ImageView.bindStatus(status: NetworkStatus) {
    when (status) {
        NetworkStatus.DONE -> this.visibility = View.GONE
        NetworkStatus.ERROR -> this.visibility = View.VISIBLE
        else -> this.visibility = View.GONE
    }
}