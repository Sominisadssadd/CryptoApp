package com.example.cryptoapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel
import com.example.cryptoapp.databinding.CoinInfoItemBinding
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(val context: Context) :
    ListAdapter<CoinPriceInfo, CoinInfoAdapter.MyViewHolder>(DiffUtilCallBack()) {


    var onClickListener: ((coinName: CoinPriceInfo) -> Unit)? = null


    inner class MyViewHolder(val binding: CoinInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)


        val binding = CoinInfoItemBinding.inflate(
            inflater,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCoin = getItem(position)
        holder.binding.coinPriceInfo = currentCoin
        with(holder) {
            itemView.setOnClickListener {
                onClickListener?.invoke(currentCoin)
            }
        }


    }


}