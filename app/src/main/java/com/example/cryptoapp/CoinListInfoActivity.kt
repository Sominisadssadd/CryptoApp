package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.adapter.CoinInfoAdapter
import com.example.cryptoapp.api.ApiFactory
import io.reactivex.rxjava3.schedulers.Schedulers

class CoinListInfoActivity : AppCompatActivity() {

    private val viewModel: CoinViewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }

    private lateinit var coinAdapter: CoinInfoAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewCoins)
        coinAdapter = CoinInfoAdapter(this)
        viewModel.listOfCoinInfo.observe(this) {
            coinAdapter.listOfCoinInfo = it
        }
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@CoinListInfoActivity)
            adapter = coinAdapter
        }
        coinAdapter.onClickListener = {
            startActivity(CoinPriceInfoActivity.newIntent(this, it))
        }
    }
}