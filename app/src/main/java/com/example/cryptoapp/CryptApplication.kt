package com.example.cryptoapp

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.api.ApiFactory
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl

import com.example.cryptoapp.di.DaggerApplicationComponent
import com.example.cryptoapp.presentation.viewmodels.CoinViewModelFactory
import com.example.cryptoapp.workers.MyWorkerFactory
import javax.inject.Inject

class CryptApplication : Application(), Configuration.Provider {


    @Inject
     lateinit var workFactory: MyWorkerFactory

    val injection by lazy {
        DaggerApplicationComponent.factory()
            .create(this, this)
    }

    override fun onCreate() {
        super.onCreate()
        injection.inject(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workFactory)
            .build()

    }
}