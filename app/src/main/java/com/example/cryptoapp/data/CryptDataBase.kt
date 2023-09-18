package com.example.cryptoapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp.data.database.entitiesDb.CoinPriceInfoDbModel

@Database(entities = [CoinPriceInfoDbModel::class], version = 1, exportSchema = false)
abstract class CryptDataBase : RoomDatabase() {


    abstract fun daoDb(): CryptDbDao

    companion object {

        private var instance: CryptDataBase? = null
        private const val DATABASE_NAME = "Cry.db"
        private val LOCK = Any()

        fun getInstance(context: Context): CryptDataBase {
            synchronized(LOCK) {
                instance?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    CryptDataBase::class.java,
                    DATABASE_NAME
                ).build()

                instance = db
                return db
            }
        }

    }

}