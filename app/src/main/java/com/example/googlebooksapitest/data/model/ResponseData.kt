package com.example.googlebooksapitest.data.model

import com.example.googlebooksapitest.presenter.model.BookModel

data class ResponseData(

    val body: BooksResponse?,
    val favorites: List<BookModel>?,
    val msg: String,
    val success: Boolean
)
