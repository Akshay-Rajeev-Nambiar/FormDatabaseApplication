package com.example.formapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FormDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(data: FormData)

    @Query("SELECT * FROM formdata")
    fun readAll(): List<FormData>

    @Query("SELECT * FROM formdata WHERE firstName IN (:name)")
    fun readByName(name: String): List<FormData>

    @Query("UPDATE formdata SET dob = :dob ,position = :position WHERE firstName IN (:firstName)")
    fun updateData(firstName: String, dob: String, position: String)
}