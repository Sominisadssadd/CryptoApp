package com.example.cryptoapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.di.qualifiers.FSymQualifier
import com.example.cryptoapp.domain.CryptDbRepository
import com.example.cryptoapp.domain.pojo.CoinPriceInfo
import com.example.cryptoapp.domain.usecases.GetCoinInfoDbUseCase
import javax.inject.Inject



class CoinInfoViewModel @Inject constructor(
    application: Application,
    @FSymQualifier fSym: String,
    useCaseGetCoinInfo: GetCoinInfoDbUseCase
) : AndroidViewModel(application) {


    private var _coinInfo: LiveData<CoinPriceInfo>
    val coiInfo: LiveData<CoinPriceInfo>
        get() = _coinInfo

    init {
        _coinInfo = useCaseGetCoinInfo(fSym = fSym)
    }


}