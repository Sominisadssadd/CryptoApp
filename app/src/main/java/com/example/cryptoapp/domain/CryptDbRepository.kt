package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel
import com.example.cryptoapp.domain.pojo.CoinPriceInfo

interface CryptDbRepository {

    fun addCoinPriceInfoList(list: List<CoinPriceInfoDbModel>)

    fun getSingleCoinPriceInfo(fSym: String): LiveData<CoinPriceInfo>

    fun getListOfCoinsFromDb(): LiveData<List<CoinPriceInfo>>
}