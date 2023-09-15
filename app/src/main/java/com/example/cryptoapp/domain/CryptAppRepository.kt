package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.entities.CoinInfo
import com.example.cryptoapp.data.entities.CoinPriceInfoDbModel

interface CryptAppRepository {

    fun getListOfCoins(): LiveData<List<CoinPriceInfoDbModel>>

    fun getCoinInfo(idOfCoin: Int): LiveData<CoinInfo>

    fun addListCoinInfo(listOfCoin: List<CoinPriceInfoDbModel>)
}