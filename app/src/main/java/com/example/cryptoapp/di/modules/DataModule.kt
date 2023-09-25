package com.example.cryptoapp.di.modules

import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.di.ApplicationScope
import com.example.cryptoapp.domain.CryptApiRepository
import com.example.cryptoapp.domain.CryptDbRepository
import dagger.Binds
import dagger.Module


@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindCryptDbRepository(repository: CryptDbRepositoryImpl): CryptDbRepository

    @Binds
    fun bindCryptApiRepository(repository: CryptApiRepositoryImpl): CryptApiRepository

}