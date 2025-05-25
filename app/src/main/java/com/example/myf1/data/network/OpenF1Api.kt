package com.example.myf1.data.network

import com.example.myf1.data.model.Driver
import retrofit2.http.GET

interface OpenF1Api {
    @GET("v1/drivers?session_key=latest&meeting_key=latest")
    suspend fun getDrivers(): List<Driver>


}