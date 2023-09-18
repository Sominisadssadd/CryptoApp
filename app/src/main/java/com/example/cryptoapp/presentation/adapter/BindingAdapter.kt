package com.example.cryptoapp.presentation.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso


@BindingAdapter("setTextCoinNameFLI")
fun setTextForCoinNameTextView(textView: TextView, coinPriceInfo: CoinPriceInfo) {
    textView.text = String.format(
        textView.context.getString(
            R.string.text_view_coin_name_formatted,
            coinPriceInfo.fromsymbol,
            coinPriceInfo.tosymbol
        )
    )
}




@BindingAdapter("setLastUpdateText")
fun setFormattedTextForTextView(textView: TextView, text: String) {
    textView.text = String.format(
        textView.context.getString(R.string.text_view_last_update_formatted),
        text
    )
}

@BindingAdapter("setImageForListItem")
fun setImageForImageView(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}