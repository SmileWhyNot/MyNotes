package com.example.mynotes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mynotes.model.Note
import com.example.mynotes.utils.TYPE_FIREBASE
import com.example.mynotes.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application = application) {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value =
            when(dbType.value) {
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "Note 1", subtitle = "Sub Note 1"),
                        Note(title = "Note 2", subtitle = "Sub Note 2"),
                        Note(title = "Note 3", subtitle = "Sub Note 3"),
                        Note(title = "Note 4", subtitle = "Sub Note 4"),
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }

    fun initDB(type: String) {
        dbType.value = type
        Log.d("checkData", "MainViewModel initDB with $type")
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