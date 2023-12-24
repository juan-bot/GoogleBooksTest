package com.example.googlebooksapitest.domain.repository

import com.example.googlebooksapitest.data.model.BooksResponse
import com.example.googlebooksapitest.data.model.ResponseData
import com.example.googlebooksapitest.data.network.RetrofitBooks
import retrofit2.Response

class GetBooksRepository {
    suspend fun getByWord(words: String): Response<BooksResponse> {
        return RetrofitBooks.api().getBooks(words)

    }

}