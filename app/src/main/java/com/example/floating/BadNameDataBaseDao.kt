package com.example.floating
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface BadNameDataBaseDao {
    @Insert
    fun insertBad(name: BadFriendName)

    @Update
    fun updateBad(name: BadFriendName)

    @Query("SELECT * from bad_friends_names_table WHERE badFrnID = :key")
    fun get2(key: Long): BadFriendName

    @Query("DELETE FROM bad_friends_names_table")
    fun clear()

    @Query("SELECT * FROM bad_friends_names_table ORDER BY badFrnID DESC")
    fun getAllBadNames(): LiveData<List<BadFriendName>>

    @Query("SELECT * FROM bad_friends_names_table ORDER BY badFrnID DESC LIMIT 1 ")
    fun getCurrBadName(): BadFriendName?
}