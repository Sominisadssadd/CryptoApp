package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinListInfo
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {



    @GET("top/totalvolfull")
    fun getListOfCoins(
        @Query(API_KEY_KEY) apiKey: String = API_KEY,
        @Query(KEY_LIMIT) limit: Int = 10,
        @Query(KEY_TSYM_FOR_FIRST_REQUEST) tSym: String = MAIN_CURRENCY,
    ): Single<CoinListInfo>


    @GET("pricemultifull")
    fun getPriceInfo(
        @Query(API_KEY_KEY) apiKey: String = API_KEY,
        @Query(KEY_FSYM) fSym: String,
        @Query(KEY_TSYM_FOR_SECOND_REQUEST) tSym: String = MAIN_CURRENCY
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val API_KEY_KEY = "api_key"
        private const val KEY_LIMIT = "limit"
        private const val KEY_TSYM_FOR_FIRST_REQUEST = "tsym"
        private const val KEY_TSYM_FOR_SECOND_REQUEST = "tsyms"
        private const val KEY_FSYM = "fsyms"
        private const val MAIN_CURRENCY = "USD"
        private const val API_KEY = "4bc289aa09b2a61069e9042114f82bfe4c407f6cfa37fbd8ed78037b2c9b0918"

    }

}