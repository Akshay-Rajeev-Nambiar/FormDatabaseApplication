package com.example.formapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FormAdapter(private val list: List<String>) : RecyclerView.Adapter<FormAdapter.FormViewHolder>(){
    class FormViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val formItem : TextView = view.findViewById(R.id.form_item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormAdapter.FormViewHolder {
        return FormViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.form_item,parent,false))
    }

    override fun onBindViewHolder(holder: FormAdapter.FormViewHolder, position: Int) {
        holder.formItem.text = list[position]
    }

    override fun getItemCount(): Int = list.size

}