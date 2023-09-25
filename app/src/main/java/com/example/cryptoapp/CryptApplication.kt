package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.di.DaggerApplicationComponent

class CryptApplication : Application() {

    val injection by lazy {
        DaggerApplicationComponent.factory()
            .create(this, this)
    }
}