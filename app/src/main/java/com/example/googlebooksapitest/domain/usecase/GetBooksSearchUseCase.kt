package com.example.googlebooksapitest.domain.usecase

import com.example.googlebooksapitest.data.model.ResponseData
import com.example.googlebooksapitest.domain.repository.GetBooksRepository

class GetBooksSearchUseCase {
    private val repository = GetBooksRepository()
    suspend operator fun invoke(cad: String, key: String): ResponseData {
        val response = repository.getByWord(cad,key)
        return if(response.isSuccessful){

            val responseBody = response.body()
            if(responseBody != null){
                ResponseData(body = response.body(), success = true, msg ="YES")
            } else {
                ResponseData(body = null, success = false, msg ="Error")
            }
        } else {
            ResponseData(body = null, success = false, msg ="Error")
        }
    }
}