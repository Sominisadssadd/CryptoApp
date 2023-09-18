package com.example.cryptoapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CoinViewModelFactory(
    private val application: Application,
    private val fSym: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinInfoViewModel::class.java)) {
            return CoinInfoViewModel(application, fSym) as T
        }
        throw RuntimeException("Unknown ViewModel class")
    }
}