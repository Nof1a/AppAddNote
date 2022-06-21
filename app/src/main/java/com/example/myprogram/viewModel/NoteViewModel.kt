package com.example.myprogram.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import androidx.room.Insert
import com.example.myprogram.data.NoteDATABASE
import com.example.myprogram.model.Notee
import com.example.myprogram.repository.noteeRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(Application:Application) : AndroidViewModel(Application) {

    private val repos: noteeRepository

    val all_note: LiveData<List<Notee>>

    init {


        val dao = NoteDATABASE.getDatabase(Application).Notee_D()
        repos = noteeRepository(dao)
        all_note = repos.all_note

    }

    fun Insert(notee: Notee) = viewModelScope.launch(Dispatchers.IO) {
        repos.Insert(notee)
    }

    fun Delete(notee: Notee) = viewModelScope.launch(Dispatchers.IO) {
        repos.Delete(notee)


    }
}