package com.example.googlebooksapitest.domain.usecase

import android.content.Context
import com.example.googlebooksapitest.data.model.ResponseData
import com.example.googlebooksapitest.domain.repository.BooksRepository
import com.example.googlebooksapitest.presenter.model.BookModel

class GetFavoritesBooksUseCase {
    private val repository = BooksRepository()

    suspend fun getFavorites(context: Context): ResponseData {
        val res = repository.getFavorites(context)

        if(res.isEmpty()){
            return ResponseData(body = null,null, success = false, msg ="error")
        }else{
            var books = mutableListOf<BookModel>()
            for (item in res){
                books.add(
                    BookModel(
                        item.title,
                        item.imgCover,
                        item.author,
                        item.published,
                        item.description,
                        item.linkToWeb,
                        item.favorite
                    )
                )
            }
            return ResponseData(body = null,books, success = true, msg ="YES")
        }
    }

}