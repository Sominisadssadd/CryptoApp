package com.example.cryptoapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.adapter.CoinInfoAdapter
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.databinding.ActivityCoinPriceInfoBinding
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.usecases.AddCoinInfoUseCase
import com.example.cryptoapp.domain.usecases.GetListOfCoinsDbUseCase
import com.example.cryptoapp.presentation.viewmodels.CoinViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinListInfoActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: CoinViewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }
    private lateinit var coinAdapter: CoinInfoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        initRecyclerView()

        viewModel.listOfCoinInfo.observe(this) {
            coinAdapter.submitList(it)
        }


    }

    private fun initRecyclerView() {
        coinAdapter = CoinInfoAdapter(this)
        with(binding.recyclerViewCoinList) {
            layoutManager = LinearLayoutManager(this@CoinListInfoActivity)
            adapter = coinAdapter
        }
        if (binding.fragmentContainer == null) {
            coinAdapter.onClickListener = {
                startActivity(CoinPriceInfoActivity.newIntent(this, it))
            }
        } else {
            coinAdapter.onClickListener = {
                supportFragmentManager.popBackStack()
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainer!!.id, CoinPriceInfoFragment.newInstance(it))
                    .commit()
            }
        }
    }


}