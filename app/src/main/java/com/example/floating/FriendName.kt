package com.example.floating

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "friend_names_table")
data class FriendName (

    @PrimaryKey(autoGenerate = true)
    var frnID: Long = 0L,
    @ColumnInfo(name = "frn_names")
    var frnnaam: String = ""
)