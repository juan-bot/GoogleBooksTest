package com.example.googlebooksapitest.presenter.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebooksapitest.domain.usecase.InsertBooksUseCase
import com.example.googlebooksapitest.presenter.model.BookModel
import kotlinx.coroutines.launch

class BookDetalViewModel: ViewModel()  {
    private val insertBooksUseCase = InsertBooksUseCase()
    fun insertBook(context: Context, bookEntity: BookModel){
        viewModelScope.launch {
            insertBooksUseCase.insertBook(context,bookEntity)
        }

    }
}