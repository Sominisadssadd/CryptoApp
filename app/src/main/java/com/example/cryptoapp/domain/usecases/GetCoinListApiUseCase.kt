package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptApiRepository
import javax.inject.Inject

class GetCoinListApiUseCase @Inject constructor(
    val repository: CryptApiRepository
) {

    operator suspend fun invoke(limit: Int, tSym: String) = repository.getListOfCoins(limit, tSym)

}