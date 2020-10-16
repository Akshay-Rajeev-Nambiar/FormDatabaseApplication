package com.example.formapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    private val insertFragment = InsertFragment()
    private val displayFragment = DisplayFragment()
    private val searchFragment = SearchFragment()
    private val updateFragment = UpdateFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.insert_btn -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, insertFragment)
                    .commit()
            }
            R.id.display_btn -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, displayFragment)
                    .commit()
            }
            R.id.search_btn -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, searchFragment)
                    .commit()
            }
            R.id.update_btn -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, updateFragment)
                    .commit()
            }
        }
    }
}