package com.example.googlebooksapitest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}