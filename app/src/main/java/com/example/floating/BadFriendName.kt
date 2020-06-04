package com.example.floating

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bad_friends_names_table")
data class BadFriendName (

    @PrimaryKey(autoGenerate = true)
    var badFrnID: Long = 0L,

    @ColumnInfo(name = "bad_frn_names")
    var badFrnNaam: String = ""
)