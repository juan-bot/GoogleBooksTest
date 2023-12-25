package com.example.googlebooksapitest.domain.repository

import android.content.Context
import com.example.googlebooksapitest.data.local.AppDataBase
import com.example.googlebooksapitest.data.local.BookEntity
import com.example.googlebooksapitest.data.local.DataBase
import com.example.googlebooksapitest.data.model.BooksResponse
import com.example.googlebooksapitest.data.network.RetrofitBooks
import retrofit2.Response

class GetBooksRepository {
    suspend fun getByWord(words: String, key: String): Response<BooksResponse> {
        return RetrofitBooks.api().getBooks(words, key)

    }
    suspend fun getFavorites(context: Context): List<BookEntity> {
        var db = createDB(context)
        return db.bookDao().getAll()

    }
    private suspend fun createDB(context: Context): AppDataBase {
        return DataBase(context).getDB()
    }
}