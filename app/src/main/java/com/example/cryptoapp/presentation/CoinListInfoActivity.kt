package com.example.cryptoapp.presentation

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.CryptApplication
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
import com.example.cryptoapp.presentation.viewmodels.CoinViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinListInfoActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    private val component by lazy {
        (application as CryptApplication)
            .injection
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


}