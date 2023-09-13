package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinListInfo
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getListOfCoins(
        @Query(API_KEY) apiKey: String,
        @Query(KEY_LIMIT) limit: Int = 10,
        @Query(KEY_TSYM) tSym: String = MAIN_CURRENCY,
    ): Single<CoinListInfo>


    @GET("pricemultifull")
    fun getPriceInfo(
        @Query(API_KEY) apiKey: String,
        @Query(KEY_FSYM) fSym: String,
        @Query(KEY_TSYM) tSym: String = MAIN_CURRENCY
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val API_KEY = "api_key"
        private const val KEY_LIMIT = "limit"
        private const val KEY_TSYM = "tsym"
        private const val KEY_FSYM = "fsyms"
        private const val MAIN_CURRENCY = "USD"

    }

}