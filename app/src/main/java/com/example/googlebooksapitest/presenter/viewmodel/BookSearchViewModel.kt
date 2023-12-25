package com.example.googlebooksapitest.presenter.viewmodel

import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebooksapitest.domain.repository.GetBooksRepository
import com.example.googlebooksapitest.domain.usecase.GetBooksSearchUseCase
import com.example.googlebooksapitest.presenter.model.BookModel
import com.example.googlebooksapitest.presenter.view.adapter.AdpBookList
import kotlinx.coroutines.launch

class BookSearchViewModel: ViewModel()  {

    private lateinit var adapter: AdpBookList
    var adpBookList: MutableLiveData<AdpBookList> = MutableLiveData()
    private val repo = GetBooksSearchUseCase()
    fun searchBooksFromWeb(words: String){
        viewModelScope.launch {
            val key = "AIzaSyCCWDp98j__XlMqeMfjADfut2xjVFj-Mig"
            val response = repo.invoke(words,key)
            if(response.success){
                var books = mutableListOf<BookModel>()
                for(item in response.body?.items!!) {
                    val volumeInfo = item.volumeInfo
                    var imglink = if (volumeInfo.imageLinks == null){
                        ""
                    }
                    else {
                        volumeInfo.imageLinks.smallThumbnail
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
                adapter = AdpBookList(books)
                adpBookList.postValue(adapter)
            }

        }
    }
}