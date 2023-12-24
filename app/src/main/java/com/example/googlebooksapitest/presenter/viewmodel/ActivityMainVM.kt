package com.example.googlebooksapitest.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebooksapitest.domain.repository.GetBooksRepository
import kotlinx.coroutines.launch

class ActivityMainVM: ViewModel() {
    fun getBooks(){
        viewModelScope.launch {
            val usecase = GetBooksRepository()
            val res = usecase.getByWord("harry potter")
        }
    }
}