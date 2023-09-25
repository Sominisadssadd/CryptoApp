package com.example.cryptoapp.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.di.modules.ChildWorkerFactory
import com.example.cryptoapp.domain.usecases.AddCoinInfoUseCase
import com.example.cryptoapp.domain.usecases.GetCoinListApiUseCase
import com.example.cryptoapp.presentation.viewmodels.CoinViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class WorkerRefreshData @Inject constructor(
    context: Context,
    workerParameters: WorkerParameters,
    val repositoryApi: CryptApiRepositoryImpl,
    val repositoryDb: CryptDbRepositoryImpl
) : CoroutineWorker(context, workerParameters) {


    override suspend fun doWork(): Result {
        while (true) {
            try {
                val listOfCoins = repositoryApi.getListOfCoins(15, CoinViewModel.MAIN_CURRENCY)
                repositoryDb.addCoinPriceInfoList(listOfCoins)


            } catch (e: Exception) {

            }
            Log.d("MAINACTIVITY", "update")
            delay(10000)
        }


    }


    companion object {
        const val WORKER_NAME = "CoinWorker"

        fun getWorkRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<WorkerRefreshData>()
                .setConstraints(getConstraints())
                .build()
        }

        private fun getConstraints(): Constraints {
            return Constraints.Builder().setRequiresCharging(true).build()
        }

    }

    class WorkerFactory @Inject constructor(
        val repositoryApi: CryptApiRepositoryImpl,
        val repositoryDb: CryptDbRepositoryImpl
    ) : ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return WorkerRefreshData(
                context, workerParameters, repositoryApi, repositoryDb
            )
        }

    }

}