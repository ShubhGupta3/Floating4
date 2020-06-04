package com.example.floating

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [FriendName::class],version = 1,exportSchema = false)
abstract class NameDataBase: RoomDatabase(){
    abstract val nameDatabaseDao : NameDatabaseDao
    companion object
    {
        @Volatile
        private var INSTANCE : NameDataBase? = null

        fun getInstance(context: Context): NameDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NameDataBase::class.java,
                        "name_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE= instance
                }
                return instance
            }

        }
    }

}