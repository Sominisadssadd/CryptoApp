package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityCoinPriceInfoBinding
import com.example.cryptoapp.data.entities.CoinPriceInfoDbModel
import com.squareup.picasso.Picasso

class CoinPriceInfoActivity : AppCompatActivity() {

    lateinit var viewModel: CoinViewModel
    private val binding by lazy {
        ActivityCoinPriceInfoBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        if (!intent.hasExtra(EXTRA_KEY)) {
            finish()
            return
        }


        val fSym = intent.getStringExtra(EXTRA_KEY) ?: ""


        viewModel.getSinglePriceInfo(fSym).observe(this) {
            updateFields(it)
        }

    }

    private fun updateFields(coinPriceInfo: CoinPriceInfoDbModel) {
        with(binding) {
            textViewNameCoinInfo.text = String.format(
                getString(R.string.text_view_coin_name_formatted),
                coinPriceInfo.fromsymbol,
                coinPriceInfo.tosymbol
            )
            textViewCostCoinInfo.text = String.format(
                getString(R.string.textViewCost),
                coinPriceInfo.price
            )
            textViewCostMin.text = String.format(
                getString(R.string.textMinDay),
                coinPriceInfo.low24hour
            )
            textViewCostMax.text = String.format(
                getString(R.string.textMaxDay),
                coinPriceInfo.high24hour
            )
            textViewLastDeal.text = String.format(
                getString(R.string.textViewDeal),
                coinPriceInfo.lastmarket
            )
            textViewLastUpdateCoinInfo.text = String.format(
                getString(R.string.textViewUpdate),
                coinPriceInfo.getConvertedTime()
            )
            Picasso.get().load(coinPriceInfo.getFullImagePath()).into(imageViewCoinInfo)
        }


    }

    companion object {
        private const val EXTRA_KEY = "fSym"

        fun newIntent(context: Context, fSym: String): Intent {
            return Intent(context, CoinPriceInfoActivity::class.java)
                .putExtra(EXTRA_KEY, fSym)
        }
    }
}