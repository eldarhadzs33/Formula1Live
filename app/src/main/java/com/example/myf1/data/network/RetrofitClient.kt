package com.example.myf1.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: OpenF1Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openf1.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenF1Api::class.java)
    }
}