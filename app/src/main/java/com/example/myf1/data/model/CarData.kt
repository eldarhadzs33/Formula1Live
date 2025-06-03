package com.example.myf1.data.model

data class CarData(
    val date: String,
    val driver_number: Int,
    val meeting_key: Int,
    val session_key: Int,
    val speed: Float,
    val rpm: Int,
    val n_gear: Int,
    val throttle: Float,
    val brake: Int,
    val drs: Int
)
