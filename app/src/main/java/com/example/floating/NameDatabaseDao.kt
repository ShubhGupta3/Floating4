package com.example.floating

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.selects.select



@Dao
interface NameDatabaseDao {
    @Insert
    fun insert(name: FriendName)

    @Update
    fun update(name: FriendName)

    @Query("SELECT * from friend_names_table WHERE frnID = :key")
    fun get(key: Long): FriendName

    @Query("DELETE FROM friend_names_table")
    fun clear()

    @Query("SELECT * FROM friend_names_table ORDER BY frnID DESC")
    fun getAllNames(): LiveData<List<FriendName>>

    @Query("SELECT * FROM friend_names_table ORDER BY frnID DESC LIMIT 1 ")
    fun getCurrName(): FriendName?
}