package com.example.cryptoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel

class CoinInfoAdapter(val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.MyViewHolder>() {


    var onClickListener: ((coinName: String) -> Unit)? = null

    var listOfCoinInfo: List<CoinPriceInfoDbModel> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCoin = view.findViewById<ImageView>(R.id.imageOfCoinInList)
        val textViewCoinName = view.findViewById<TextView>(R.id.textViewCoinName)
        val textViewCoinPrice = view.findViewById<TextView>(R.id.textViewCoinPrice)
        val textViewLastUpdate = view.findViewById<TextView>(R.id.textViewLastUpdate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.coin_info_item,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCoin = listOfCoinInfo[position]


//        with(holder) {
//            textViewCoinName.text = String.format(
//                context.getString(R.string.text_view_coin_name_formatted),
//                currentCoin.fromsymbol,
//                currentCoin.tosymbol
//            )
//            textViewCoinPrice.text = currentCoin.price.toString()
//            textViewLastUpdate.text = String.format(
//                context.getString(R.string.text_view_last_update_formatted),
//                currentCoin.getConvertedTime()
//            )
//            Picasso.get()
//                .load(currentCoin.getFullImagePath())
//                .into(imageViewCoin)
//
//            itemView.setOnClickListener {
//                onClickListener?.invoke(currentCoin.fromsymbol)
//            }
//        }




    }

    override fun getItemCount() = listOfCoinInfo.size

}