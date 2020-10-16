package com.example.formapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.name_search_btn
import kotlinx.android.synthetic.main.fragment_update.*

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var formDatabase: FormDatabase
    private lateinit var searchRv: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchRv = view.findViewById(R.id.search_rv)
        formDatabase =
            Room.databaseBuilder(view.context, FormDatabase::class.java, "FormDatabase").build()
        searchRv.layoutManager = LinearLayoutManager(view.context)
        update_data_btn.setOnClickListener {
            displayByName(name_et.text.toString())
        }
    }

    fun displayByName(name: String) {
        val list: MutableList<FormData> = mutableListOf()
        Thread {
            list.addAll(formDatabase.formDao().readByName(name))
            searchRv.post {
                if (list.isEmpty()) Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
                else {
                    val dispList: MutableList<String> = mutableListOf()
                    list.forEach {
                        dispList.add("${it.firstName} ${it.lastName} ${it.dob} ${it.position}")
                    }
                    searchRv.adapter = FormAdapter(dispList)
                }
            }
        }.start()
    }
}