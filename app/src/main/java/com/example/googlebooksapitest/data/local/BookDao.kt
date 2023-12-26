package com.example.googlebooksapitest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface BookDao {
    @Query("SELECT * FROM Book")
    fun getAll(): List<BookEntity>
    @Insert
    fun insert(vararg book: BookEntity)
}