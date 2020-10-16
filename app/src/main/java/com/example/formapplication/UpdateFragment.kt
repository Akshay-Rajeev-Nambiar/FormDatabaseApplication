package com.example.formapplication


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_update.*

class UpdateFragment : Fragment(R.layout.fragment_update) {
    private lateinit var formDatabase: FormDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        formDatabase =
            Room.databaseBuilder(view.context, FormDatabase::class.java, "FormDatabase").build()
        update_data_btn.setOnClickListener {
            if (first_name_et.text.isEmpty()) Toast.makeText(
                view.context,
                "First name cant be empty !",
                Toast.LENGTH_SHORT
            ).show()
            else {
                val firstName = first_name_et.text.toString()
                val dob = dob_et.text.toString()
                val position = postion_et.text.toString()
                updateData(firstName, dob, position)
            }
        }
    }

    fun updateData(firstName: String, dob: String, position: String) {
        Thread {
            formDatabase.formDao().updateData(firstName, dob, position)
        }.start()
    }

}