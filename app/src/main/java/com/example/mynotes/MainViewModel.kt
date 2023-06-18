package com.example.mynotes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mynotes.database.room.AppRoomDatabase
import com.example.mynotes.database.room.repository.RoomRepository
import com.example.mynotes.model.Note
import com.example.mynotes.utils.REPOSITORY
import com.example.mynotes.utils.TYPE_FIREBASE
import com.example.mynotes.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application = application) {

    private val context = application

    fun initDB(type: String, onSuccess: ()->Unit) {
        Log.d("checkData", "MainViewModel initDB with $type")
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}