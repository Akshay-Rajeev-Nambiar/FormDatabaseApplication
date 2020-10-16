package com.example.formapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class DisplayFragment : Fragment(R.layout.fragment_display) {
    private lateinit var formDatabase: FormDatabase
    private lateinit var displayRv : RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        formDatabase = Room.databaseBuilder(view.context,FormDatabase::class.java,"FormDatabase").build()
        displayRv = view.findViewById(R.id.display_rv)
        displayRv.layoutManager = LinearLayoutManager(view.context)
        displayFormData()
    }
    fun displayFormData(){
        val list : MutableList<FormData> = mutableListOf()
        Thread{
            list.addAll(formDatabase.formDao().readAll())
            displayRv.post {
                if (list.isEmpty()) Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
                else{
                    val dispList : MutableList<String> = mutableListOf()
                    list.forEach {
                        dispList.add("${it.firstName} ${it.lastName} ${it.dob} ${it.position}")
                    }
                    displayRv.adapter = FormAdapter(dispList)
                }
            }
        }.start()
    }
}