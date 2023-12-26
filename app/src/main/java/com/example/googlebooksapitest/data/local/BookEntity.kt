package com.example.googlebooksapitest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int? ,
    val title: String,
    val imgCover: String,
    val author: String,
    val published: String?,
    val description: String?,
    val linkToWeb: String,
    val favorite: Boolean
)