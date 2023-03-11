package com.example.retrofitwithmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: Repository):ViewModel(){


    private val error=MutableLiveData<Throwable>()

    fun getData():LiveData<ApiResponseProductModel>{
        val response=MutableLiveData<ApiResponseProductModel>()
        repository.getProduct(response,error)
        return response
    }
}