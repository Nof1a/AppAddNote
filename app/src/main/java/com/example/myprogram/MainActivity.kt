package com.example.myprogram
import com.example.myprogram.repository.noteeRepository
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myprogram.model.Notee
import com.example.myprogram.viewModel.NoteViewModel
import com.example.myprogram.data.NoteDATABASE
import com.example.myprogram.data.Notee_D
import com.example.myprogram.NoteAdaptor
import com.example.myprogram.AddNoteeActivity



class MainActivity : AppCompatActivity(), IAdaptor {

    private lateinit var viewModel : NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerview)////maby wrpng
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adaptor =NoteAdaptor(this)
        recyclerView.adapter=adaptor

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        viewModel.all_note.observe(this, Observer { adaptor.updatedata(it) })
    }

    fun addNotee(view: View) {
        val intent=Intent(this,AddNoteeActivity::class.java)
        startActivity(intent)

    }

    override fun onNoteClick(notee: Notee) {
        viewModel.Delete(notee)
    }
}