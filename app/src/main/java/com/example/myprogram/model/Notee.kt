package com.example.myprogram.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.recyclerview.widget.RecyclerView

//this our note Data Base

@Entity(tableName = "Note_DataBaseTable")
data class Notee(@ColumnInfo(name = "text") val text:String) {
    @PrimaryKey(autoGenerate = true)
    var id =0



}