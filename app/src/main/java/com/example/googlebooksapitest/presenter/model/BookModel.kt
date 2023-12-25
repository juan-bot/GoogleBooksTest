package com.example.googlebooksapitest.presenter.model

data class BookModel(
    var title: String,
    var imgCover: String,
    var author: String,
    var published: String?,
    var description: String?,
    var linkToWeb: String,
    var favorite: Boolean
)
