package com.example.myprogram

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import com.example.myprogram.data.NoteDATABASE
import com.example.myprogram.model.Notee
import com.example.myprogram.repository.noteeRepository


class NoteAdaptor(private val listener:IAdaptor) :RecyclerView.Adapter<NoteAdaptor.NotesViewHolder>() {
    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val textview : TextView = itemView.findViewById(R.id.text)
            val delete_but : ImageView= itemView.findViewById(R.id.delete_but)
}

    private val allnotee = ArrayList<Notee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notee,parent,false))
        viewHolder.delete_but.setOnClickListener{
            listener.onNoteClick(allnotee[viewHolder.adapterPosition])
        }
    return viewHolder
     }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
val currentItem = allnotee[position]
    holder.textview.text=currentItem.text}

    override fun getItemCount(): Int {
         return allnotee.size
    }

    fun updatedata(newData : List<Notee>){
        allnotee.clear()
        allnotee.addAll(newData)
        notifyDataSetChanged()
    }




}
interface IAdaptor{
    fun onNoteClick(notee: Notee)
}