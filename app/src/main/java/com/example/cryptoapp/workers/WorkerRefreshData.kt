package com.example.cryptoapp.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.cryptoapp.data.api.CryptApiRepositoryImpl
import com.example.cryptoapp.data.database.CryptDbRepositoryImpl
import com.example.cryptoapp.domain.usecases.AddCoinInfoUseCase
import com.example.cryptoapp.domain.usecases.GetCoinListApiUseCase
import com.example.cryptoapp.presentation.viewmodels.CoinViewModel
import kotlinx.coroutines.delay

class WorkerRefreshData(
    context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {

    private val repositoryApi = CryptApiRepositoryImpl
    private val repositoryDb = CryptDbRepositoryImpl(context)

    private val useCaseAddListOfCoinsDb = AddCoinInfoUseCase(repositoryDb)
    private val useCaseGetListOfCoinsInfoApi = GetCoinListApiUseCase(repositoryApi)


    override suspend fun doWork(): Result {
        while (true) {
            try {
                val listOfCoins = useCaseGetListOfCoinsInfoApi(15, CoinViewModel.MAIN_CURRENCY)
                useCaseAddListOfCoinsDb(listOfCoins)


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

}