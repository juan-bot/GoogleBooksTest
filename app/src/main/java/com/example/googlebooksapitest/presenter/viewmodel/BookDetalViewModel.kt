package com.example.googlebooksapitest.presenter.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebooksapitest.domain.usecase.GetFavoritesBooksUseCase
import com.example.googlebooksapitest.presenter.model.BookModel
import kotlinx.coroutines.launch

class BookDetalViewModel: ViewModel()  {
    private val useCase = GetFavoritesBooksUseCase()
    suspend fun getFavoritesUsecase(context : Context){
        viewModelScope.launch {
            val res = useCase.getFavorites(context)
            if( res.success){
                var bankList = mutableListOf<BookModel>()
            }
        }

    }
}