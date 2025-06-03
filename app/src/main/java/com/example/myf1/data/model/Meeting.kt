package com.example.myf1.data.model

data class Meeting(
    val meeting_key: Int,
    val circuit_key: Int,
    val circuit_short_name: String,
    val meeting_code: String,
    val location: String,
    val country_key: Int,
    val country_code: String,
    val country_name: String,
    val meeting_name: String,
    val meeting_official_name:String,
    val gmt_offset: String,
    val date_start: String,
    val year: Int
)
