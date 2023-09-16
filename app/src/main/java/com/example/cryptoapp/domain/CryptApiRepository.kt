package com.example.cryptoapp.domain

import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel

interface CryptApiRepository {

    suspend fun getListOfCoins(limit: Int, tSym: String): List<CoinPriceInfoDbModel>

}