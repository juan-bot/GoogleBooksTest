package com.example.googlebooksapitest.presenter.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebooksapitest.domain.repository.GetBooksRepository
import com.example.googlebooksapitest.domain.usecase.GetBooksSearchUseCase
import com.example.googlebooksapitest.domain.usecase.GetFavoritesBooksUseCase
import com.example.googlebooksapitest.presenter.model.BookModel
import com.example.googlebooksapitest.presenter.view.BookListClickListener
import com.example.googlebooksapitest.presenter.view.adapter.AdpBookList
import kotlinx.coroutines.launch

class BookSearchViewModel(): ViewModel()  {
    private lateinit var adapter: AdpBookList
    var adpBookList: MutableLiveData<AdpBookList> = MutableLiveData()
    private val searchUseCase = GetBooksSearchUseCase()
    private val favoritesBooksUseCase = GetFavoritesBooksUseCase()
    lateinit var listener: BookListClickListener
    fun searchBooksFromWeb(words: String, listener: BookListClickListener){
        viewModelScope.launch {

            val key = "AIzaSyCCWDp98j__XlMqeMfjADfut2xjVFj-Mig"
            val response = searchUseCase.invoke(words,key)
            if(response.success){
                var books = mutableListOf<BookModel>()
                for(item in response.body?.items!!) {
                    val volumeInfo = item.volumeInfo
                    var imglink = if (volumeInfo.imageLinks == null){
                        ""
                    }
                    else {
                        item.volumeInfo.imageLinks.smallThumbnail.substring(0, 4) + 's' + item.volumeInfo.imageLinks.smallThumbnail.substring(4)
                    }
                    books.add (BookModel(
                        title = volumeInfo.title,
                        description = volumeInfo.description?:"No description",
                        imgCover = imglink,
                        author = volumeInfo?.authors?.get(0) ?:"No authors",
                        published = volumeInfo.publisher?:"No information",
                        favorite = false,
                        linkToWeb = volumeInfo.canonicalVolumeLink ,
                    ))
                }
                adapter = AdpBookList(books, listener)
                adpBookList.postValue(adapter)
            }

        }
    }
    suspend fun getFavoritesUsecase(context : Context){
        viewModelScope.launch {
            val res = favoritesBooksUseCase.getFavorites(context)
            if( res.success){
                var books = mutableListOf<BookModel>()
                adapter = AdpBookList(books, listener)
                adpBookList.postValue(adapter)
            }
        }

    }
}