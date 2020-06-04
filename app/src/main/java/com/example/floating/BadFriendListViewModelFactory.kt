package com.example.floating

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class BadFriendListViewModelFactory(
    private val dataSource2: BadNameDataBaseDao,
    private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BadFriendListViewModel::class.java)){

            return BadFriendListViewModel(dataSource2,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}