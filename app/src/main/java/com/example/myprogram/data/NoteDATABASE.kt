package com.example.myprogram.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myprogram.model.Notee


@Database(entities = [Notee::class], version = 1 , exportSchema = false)


abstract class NoteDATABASE : RoomDatabase(){

    abstract fun Notee_D(): Notee_D

    companion object {
        @Volatile
        private var INSTANCE: NoteDATABASE? = null
        fun getDatabase(context: Context): NoteDATABASE {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDATABASE::class.java,
                    "noteee_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }


}