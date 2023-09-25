package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptDbRepository
import javax.inject.Inject

class GetCoinInfoDbUseCase @Inject constructor(
    val repository: CryptDbRepository
) {

    operator fun invoke(fSym: String) = repository.getSingleCoinPriceInfo(fSym)
}