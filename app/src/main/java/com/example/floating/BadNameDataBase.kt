package com.example.floating

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BadFriendName::class],version = 1,exportSchema = false)
abstract class BadNameDataBase: RoomDatabase() {
    abstract val badNameDatabaseDao: BadNameDataBaseDao
    companion object {
        @Volatile
        private var INSTANCE: BadNameDataBase? = null

        fun getInstance(context: Context): BadNameDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BadNameDataBase::class.java,
                        "name_history_database2"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}