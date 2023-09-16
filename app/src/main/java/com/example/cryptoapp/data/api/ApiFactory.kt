package com.example.cryptoapp.data.api

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://min-api.cryptocompare.com/data/"
    const val BASE_IMAGE_URL = "https://cryptocompare.com"
    private const val API_TAG = "CRYPT_API"

    private fun createRetrofitExemplar(): Retrofit {
        val retrofit = Retrofit.Builder()
            .client(requestChecker())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    private fun requestChecker(): OkHttpClient {
       val httpClient = OkHttpClient.Builder()
           .addInterceptor{data->
               val request = data.request()
               val response = data.proceed(request)
               Log.d(API_TAG,request.toString())
               response
           }.build()

        return httpClient
    }

    val apiService = createRetrofitExemplar().create(ApiService::class.java)
}