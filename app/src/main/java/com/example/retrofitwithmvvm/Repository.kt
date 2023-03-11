package com.example.retrofitwithmvvm

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val restApi: RestApi) {

    fun getProduct(data: MutableLiveData<ApiResponseProductModel>,error:MutableLiveData<Throwable>){
        restApi.getProduct().enqueue(object : Callback<ApiResponseProductModel?> {
            override fun onResponse(
                call: Call<ApiResponseProductModel?>,
                response: Response<ApiResponseProductModel?>
            ) {
                data.value=response.body()
            }

            override fun onFailure(call: Call<ApiResponseProductModel?>, t: Throwable) {
               error.value=t
            }
        })
    }

}