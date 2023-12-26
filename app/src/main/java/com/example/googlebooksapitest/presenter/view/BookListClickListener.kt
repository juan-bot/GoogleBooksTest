package com.example.googlebooksapitest.presenter.view

import android.view.View
import com.example.googlebooksapitest.presenter.model.BookModel

interface BookListClickListener {
    fun onBookListItemClick(view: View, user: BookModel)
}