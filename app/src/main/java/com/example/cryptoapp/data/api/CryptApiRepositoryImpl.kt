package com.example.cryptoapp.data.api

import com.example.cryptoapp.data.api.entitiesApi.CoinPriceInfoApiModel
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel
import com.example.cryptoapp.data.api.entitiesApi.CoinPriceInfoRawData
import com.example.cryptoapp.data.utils.convertListOfApiCoinInfoToDbListOfCoinInfo
import com.example.cryptoapp.domain.CryptApiRepository
import com.google.gson.Gson

object CryptApiRepositoryImpl  : CryptApiRepository {

    private val api = ApiFactory.apiService

    override suspend fun getListOfCoins(limit: Int, tSym: String): List<CoinPriceInfoDbModel> {
        val coinsNames = api.getListOfCoins(limit = limit, tSym = tSym).data?.map {
            it.coinInfo?.name
        }?.joinToString(",") ?: ""


        val coinPriceInfoRawData = api.getPriceInfo(fSym = coinsNames)

        return convertListOfApiCoinInfoToDbListOfCoinInfo(parseJsonObject(coinPriceInfoRawData))

    }


    private fun parseJsonObject(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfoApiModel> {

        val priceListInfo = mutableListOf<CoinPriceInfoApiModel>()
        val jsonObject = coinPriceInfoRawData.raw ?: return emptyList()
        val ketSet = jsonObject.keySet()
        for (key in ketSet) {
            val currentJsonObject = jsonObject.getAsJsonObject(key)
            val currentKeySet = currentJsonObject.keySet()
            for (currentKey in currentKeySet) {
                val coinPriceInfo = Gson().fromJson(
                    currentJsonObject.getAsJsonObject(currentKey),
                    CoinPriceInfoApiModel::class.java
                )
                priceListInfo.add(coinPriceInfo)
            }
        }

        return priceListInfo
    }
}