package com.example.googlebooksapitest.data.network

import com.example.googlebooksapitest.data.model.BooksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceBooks {
    @GET("volumes")
    suspend fun getBooks(@Query("q") id: String?,@Query("key") apiKey: String): Response<BooksResponse>

}