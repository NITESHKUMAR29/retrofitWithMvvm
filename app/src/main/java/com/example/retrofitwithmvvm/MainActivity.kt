package com.example.retrofitwithmvvm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit= Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val restApi=retrofit.create(RestApi::class.java)

        val repository=Repository(restApi)
        mainViewModel= ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]
        val text:TextView=findViewById(R.id.textResponse)
        mainViewModel.getData().observe(this){
            text.text=it.products.toString()
           Log.d("response",it.products.toString())
        }


    }
}