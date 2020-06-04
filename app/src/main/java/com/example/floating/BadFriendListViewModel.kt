package com.example.floating

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import androidx.lifecycle.*

class BadFriendListViewModel(
    val database2: BadNameDataBaseDao,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob2 = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob2.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main+ viewModelJob2)

    private var currName = MutableLiveData<BadFriendName?>()

    private val names = database2.getAllBadNames()

    val namesString = Transformations.map(names){ names ->
        formatBadNames(names, application.resources)
    }

    init {
        initializeCurrName()
    }

    private fun initializeCurrName()
    {
        uiScope.launch {
            currName.value = getBadNameFromDatabase()
        }
    }
    private suspend fun getBadNameFromDatabase(): BadFriendName?{
        return withContext(Dispatchers.IO){
            var name2 = database2.getCurrBadName()
            if (name2?.badFrnNaam==""){
                name2 = null
            }
            name2
        }
    }
    private suspend fun insert(name2: BadFriendName){
        withContext(Dispatchers.IO){

            database2.insertBad(name2)

        }
    }

    fun onAdd2(temporary: String){
        uiScope.launch {
            val tempFriend = BadFriendName()
            tempFriend.badFrnNaam = temporary
            insert(tempFriend)
        }
    }
    fun onSave(){
        uiScope.launch {
            val oldName2 = currName.value?:return@launch
            update(oldName2)
        }
    }
    private suspend fun update(name2: BadFriendName){
        withContext(Dispatchers.IO){
            database2.updateBad(name2)
        }
    }

    fun onClear()
    {
        uiScope.launch {
            clear()
            currName.value = null
        }
    }

    suspend fun clear(){
        withContext(Dispatchers.IO){
            database2.clear()
        }
    }
}