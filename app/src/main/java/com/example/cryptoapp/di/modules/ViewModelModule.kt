package com.example.cryptoapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.api.entitiesApi.CoinInfo
import com.example.cryptoapp.di.ViewModelKey
import com.example.cryptoapp.presentation.viewmodels.CoinInfoViewModel
import com.example.cryptoapp.presentation.viewmodels.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {


    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    @Binds
    fun bindCoinViewModel(coinViewModel: CoinViewModel): ViewModel


    @IntoMap
    @ViewModelKey(CoinInfoViewModel::class)
    @Binds
    fun bindCoinInfoViewModel(coinInfoViewModel: CoinInfoViewModel): ViewModel


}