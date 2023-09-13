package com.example.cryptoapp.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"

    private fun createRetrofitExemplar(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    val apiService = createRetrofitExemplar().create(ApiService::class.java)
}