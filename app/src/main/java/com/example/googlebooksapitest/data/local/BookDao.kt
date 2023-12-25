package com.example.googlebooksapitest.data.local

import androidx.room.Dao
import androidx.room.Query
@Dao
interface BookDao {
    @Query("SELECT * FROM Book")
    fun getAll(): List<BookEntity>
}