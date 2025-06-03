package com.example.myf1.data.network

import com.example.myf1.data.model.CarData
import com.example.myf1.data.model.Driver
import com.example.myf1.data.model.Meeting
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenF1Api {
    @GET("v1/drivers?session_key=latest&meeting_key=latest")
    suspend fun getDrivers(): List<Driver>

    @GET("https://api.openf1.org/v1/meetings?meeting_key=latest")
    suspend fun getLastMeeting(): Meeting

    @GET("v1/car_data")
    suspend fun getCarData(
        @Query("session_key")sessionKey: String="latest",
        @Query("meeting_key")meetingKey: String="latest",
        @Query("driver_number")driverNumber:Int
        ):List<CarData>


}