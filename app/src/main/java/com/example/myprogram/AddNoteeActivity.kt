package com.example.myprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.myprogram.model.Notee
import com.example.myprogram.viewModel.NoteViewModel

class AddNoteeActivity : AppCompatActivity() {

    private lateinit var viewModel : NoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notee)
        // init viewmodel
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        var btn : Button=findViewById(R.id.AddNote)
        btn.setOnClickListener{
            addingNote()
        }
    }

    private fun addingNote(){

        val editText:EditText=findViewById(R.id.Input)///////////////////
        val input = editText.text.toString()
        if(input.isNotEmpty()){
            viewModel.Insert(Notee(input))
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}