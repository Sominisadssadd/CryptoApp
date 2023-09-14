package com.example.cryptoapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class CryptDataBase : RoomDatabase() {


    abstract fun daoDb(): CryptDbDao

    companion object {

        private var instance: CryptDataBase? = null
        private const val DATABASE_NAME = "crypt.db"
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