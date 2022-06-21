package com.example.myprogram.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import com.example.myprogram.data.Notee_D
import com.example.myprogram.model.Notee


class noteeRepository(private val Notee_D: Notee_D) {

    val all_note: LiveData<List<Notee>> =Notee_D.getnote()


    suspend fun Insert(notee: Notee){
        Notee_D.Insert(notee)
    }

    suspend fun Delete(notee: Notee){
        Notee_D.Delete(notee)
    }
}