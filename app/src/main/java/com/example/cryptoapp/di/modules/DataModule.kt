package com.example.cryptoapp.di.modules

import android.content.Context
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.di.ApplicationScope
import com.example.cryptoapp.domain.CryptApiRepository
import com.example.cryptoapp.domain.CryptDbRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @ApplicationScope
    @Provides
    fun bindCryptDbRepository(repository: CryptDbRepositoryImpl): CryptDbRepository{
        return repository
    }

    @Provides
    fun bindCryptApiRepository(repository: CryptApiRepositoryImpl): CryptApiRepository{
        return repository
    }

    @ApplicationScope
    @Provides
    fun bindCryptDbRepositoryImpl(context: Context): CryptDbRepositoryImpl{
        return CryptDbRepositoryImpl(context)
    }

    @ApplicationScope
    @Provides
    fun bindCryptApiRepositoryImpl(): CryptApiRepositoryImpl{
        return CryptApiRepositoryImpl
    }

}