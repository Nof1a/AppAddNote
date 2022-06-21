package com.example.myprogram.data

import androidx.lifecycle.LiveData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import androidx.room.*
import com.example.myprogram.model.Notee


@Dao

abstract class Notee_D{


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun Insert(notee: Notee)

    @Delete
    abstract suspend fun Delete(notee: Notee)

    @Query("SELECT * FROM note_databasetable ORDER BY id ASC")
    abstract fun getnote(): LiveData<List<Notee>>




}