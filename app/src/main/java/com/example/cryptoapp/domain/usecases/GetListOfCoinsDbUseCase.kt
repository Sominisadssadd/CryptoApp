package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.CryptDbRepository
import javax.inject.Inject


class GetListOfCoinsDbUseCase @Inject constructor(
    val repository: CryptDbRepository
) {

    operator fun invoke() = repository.getListOfCoinsFromDb()
}