package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.adapter.CoinInfoAdapter
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.domain.usecases.AddCoinInfoUseCase
import com.example.cryptoapp.domain.usecases.GetListOfCoinsDbUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinListInfoActivity : AppCompatActivity() {

    private val viewModel: CoinViewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }

    private lateinit var coinAdapter: CoinInfoAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initRecyclerView()


        val db = CryptDbRepositoryImpl(this)
        val useCaseAdd = AddCoinInfoUseCase(db)
        CoroutineScope(Dispatchers.IO).launch {
            val data = CryptApiRepositoryImpl.getListOfCoins(2, "USD")
            useCaseAdd(data)
        }

        val useCaseGetList = GetListOfCoinsDbUseCase(db)
        useCaseGetList().observe(this) {
            Log.d("MAINACTIVITY",it.toString())
        }

    }

//    private fun initRecyclerView() {
//        recyclerView = findViewById(R.id.recyclerViewCoins)
//        coinAdapter = CoinInfoAdapter(this)
//        viewModel.listOfCoinInfo.observe(this) {
//            coinAdapter.listOfCoinInfo = it
//        }
//        with(recyclerView) {
//            layoutManager = LinearLayoutManager(this@CoinListInfoActivity)
//            adapter = coinAdapter
//        }
//        coinAdapter.onClickListener = {
//            startActivity(CoinPriceInfoActivity.newIntent(this, it))
//        }
//    }
}