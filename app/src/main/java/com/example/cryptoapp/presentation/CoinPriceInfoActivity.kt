package com.example.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.ActivityCoinPriceInfoBinding
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.example.cryptoapp.presentation.viewmodels.CoinViewModel

class CoinPriceInfoActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityCoinPriceInfoBinding.inflate(layoutInflater)
    }
    private var currentCoin: CoinPriceInfo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent?.let {
            currentCoin = it.getSerializableExtra(KEY_COIN) as CoinPriceInfo
        }

        currentCoin?.let {
            supportFragmentManager.beginTransaction()
                .add(
                    binding.fragmentContainerCoinPriceInfo.id,
                    CoinPriceInfoFragment.newInstance(currentCoin!!)
                )
                .commit()
        }


    }


    companion object {

        private const val KEY_COIN = "coin"

        fun newIntent(context: Context, coin: CoinPriceInfo): Intent {
            return Intent(context, CoinPriceInfoActivity::class.java)
                .putExtra(KEY_COIN, coin)
        }
    }
}