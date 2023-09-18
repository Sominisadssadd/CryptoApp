package com.example.cryptoapp.presentation.adapter

import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.pojo.CoinPriceInfo

class DiffUtilCallBack : DiffUtil.ItemCallback<CoinPriceInfo>() {
    override fun areItemsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo) =
        oldItem.fromsymbol == newItem.fromsymbol

    override fun areContentsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo) =
        oldItem == newItem
}