package com.example.googlebooksapitest.domain.usecase

import com.example.googlebooksapitest.data.model.ResponseData
import com.example.googlebooksapitest.domain.repository.BooksRepository

class GetBooksSearchUseCase {
    private val repository = BooksRepository()
    suspend operator fun invoke(cad: String, key: String): ResponseData {
        val response = repository.getByWord(cad,key)
        return if(response.isSuccessful){

            val responseBody = response.body()
            if(responseBody != null){
                ResponseData(body = response.body(),null, success = true, msg ="YES")
            } else {
                ResponseData(body = null,null, success = false, msg ="Error")
            }
        } else {
            ResponseData(body = null,null, success = false, msg ="Error")
        }
    }
}