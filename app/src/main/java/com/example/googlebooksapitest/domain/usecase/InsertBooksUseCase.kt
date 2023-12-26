package com.example.googlebooksapitest.domain.usecase

import android.content.Context
import com.example.googlebooksapitest.data.local.BookEntity
import com.example.googlebooksapitest.domain.repository.BooksRepository
import com.example.googlebooksapitest.presenter.model.BookModel

class InsertBooksUseCase {
    private val repository = BooksRepository()
    suspend fun insertBook(context: Context, bookEntity: BookModel){
        val obj = BookEntity(
            null,
            bookEntity.title,
            bookEntity.imgCover,
            bookEntity.author,
            bookEntity.published,
            bookEntity.description,
            bookEntity.linkToWeb,
            bookEntity.favorite
        )
        val res = repository.insertBook(context,obj)
    }
}