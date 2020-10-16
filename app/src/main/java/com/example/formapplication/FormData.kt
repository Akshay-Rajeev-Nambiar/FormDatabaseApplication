package com.example.formapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "formdata")
data class FormData(
    @PrimaryKey @ColumnInfo(name = "firstName") val firstName : String,
    @ColumnInfo(name = "lastName")val lastName : String,
    @ColumnInfo(name = "dob")val dob : String,
    @ColumnInfo(name = "position")val position : String
)