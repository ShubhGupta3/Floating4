package com.example.floating

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import androidx.lifecycle.*

class FriendListViewModel(
    val database: NameDatabaseDao,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main+ viewModelJob)

    private var currName = MutableLiveData<FriendName?>()

    private val names = database.getAllNames()

    val namesString = Transformations.map(names){ names ->
        formatNames(names, application.resources)
    }

    init {
        initializeCurrName()
    }

    private fun initializeCurrName()
    {
        uiScope.launch {
            currName.value = getNameFromDatabase()
        }
    }
    private suspend fun getNameFromDatabase(): FriendName?{
        return withContext(Dispatchers.IO){
            var name = database.getCurrName()
            if(name?.frnnaam == ""){
                name = null
            }
            name
        }
    }
    private suspend fun insert(name: FriendName){
        withContext(Dispatchers.IO){

            database.insert(name)

        }
    }

    fun onAdd(temporary: String){
        uiScope.launch {
            val tempFriend = FriendName()
            tempFriend.frnnaam = temporary
            insert(tempFriend)
        }
    }

    fun onSave(){
        uiScope.launch {
            val oldName = currName.value?:return@launch
            update(oldName)
        }
    }
    private suspend fun update(name: FriendName){
        withContext(Dispatchers.IO){
            database.update(name)
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
            database.clear()
        }
    }
}