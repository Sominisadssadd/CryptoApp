package com.example.cryptoapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.usecases.GetCoinInfoDbUseCase

class CoinInfoViewModel(
    application: Application,
    fSym: String
) : AndroidViewModel(application) {

    private val repositoryDb = CryptDbRepositoryImpl(application)
    private val useCaseGetCoinInfo = GetCoinInfoDbUseCase(repositoryDb)

    private var _coinInfo: LiveData<CoinPriceInfo>
    val coiInfo: LiveData<CoinPriceInfo>
        get() = _coinInfo

    init {
        _coinInfo = useCaseGetCoinInfo(fSym = fSym)
    }


}