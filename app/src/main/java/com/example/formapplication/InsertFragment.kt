package com.example.formapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_insert.*

class InsertFragment : Fragment(R.layout.fragment_insert) {

    private lateinit var formDatabase: FormDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        formDatabase =
            Room.databaseBuilder(view.context, FormDatabase::class.java, "FormDatabase").build()
        insert_data_btn.setOnClickListener {
            insertFormData(
                FormData(
                    first_name_et.text.toString(),
                    last_name_et.text.toString(),
                    dob_et.text.toString(),
                    postion.text.toString()
                )
            )
            Toast.makeText(view.context, "Inserted successfully", Toast.LENGTH_SHORT).show()
        }
    }

    fun insertFormData(data: FormData) {
        Thread {
            formDatabase.formDao().insertData(data)
        }.start()
    }


}