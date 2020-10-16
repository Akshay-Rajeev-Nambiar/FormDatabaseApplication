package com.example.formapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FormData::class],version = 1)
abstract class FormDatabase : RoomDatabase() {
    abstract fun formDao() : FormDao
}