package com.example.googlebooksapitest.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBooks {
    fun api(): ApiServiceBooks {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okhttpClient = OkHttpClient.Builder()
            okhttpClient.addInterceptor(interceptor)
            Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .client(okhttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit
            .build()
            .create(ApiServiceBooks::class.java)
    }
}