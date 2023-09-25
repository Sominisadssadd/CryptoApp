package com.example.cryptoapp.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.di.modules.ChildWorkerFactory
import com.example.cryptoapp.domain.CryptApiRepository
import com.example.cryptoapp.domain.CryptDbRepository
import javax.inject.Inject
import javax.inject.Provider

class MyWorkerFactory @Inject constructor(
    val workerProviders: @JvmSuppressWildcards Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            WorkerRefreshData::class.qualifiedName -> {
                val workerFactory = workerProviders[WorkerRefreshData::class.java]?.get()
                workerFactory?.create(appContext, workerParameters)
            }
            else -> null
        }
    }
}