package com.example.googlebooksapitest.presenter.model

data class BookModel(
    val title: String,
    val cover: String,
    val author: String,
    val published: String,
    val description: String,
    val linkToWeb: String,
    val favorite: Boolean
)
