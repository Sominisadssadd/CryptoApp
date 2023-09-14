package com.example.cryptoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cryptoapp.api.ApiFactory
import com.example.cryptoapp.database.CryptDataBase
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val dbDao = CryptDataBase.getInstance(application).daoDb()
    val listOfCoinInfo = dbDao.getListCoinInfo()

    init {
        loadData()
    }

    fun getSinglePriceInfo(fSym: String): LiveData<CoinPriceInfo> {
        return dbDao.getCoinPriceInfo(fSym)
    }


    private fun loadData() {
        ApiFactory.apiService.getListOfCoins()
            .map { it.data?.map { it.coinInfo?.name }?.joinToString(",") ?: "" }
            .flatMap { ApiFactory.apiService.getPriceInfo(fSym = it) }
            .map { parseJsonObject(it) }
            .delaySubscription(10, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({
                dbDao.addCoinPriceInfoList(it)
            },
                {

                })
    }

    private fun parseJsonObject(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfo> {

        val priceListInfo = mutableListOf<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.raw ?: return emptyList()
        val ketSet = jsonObject.keySet()
        for (key in ketSet) {
            val currentJsonObject = jsonObject.getAsJsonObject(key)
            val currentKeySet = currentJsonObject.keySet()
            for (currentKey in currentKeySet) {
                val coinPriceInfo = Gson().fromJson(
                    currentJsonObject.getAsJsonObject(currentKey),
                    CoinPriceInfo::class.java
                )
                priceListInfo.add(coinPriceInfo)
            }
        }

        return priceListInfo
    }


}