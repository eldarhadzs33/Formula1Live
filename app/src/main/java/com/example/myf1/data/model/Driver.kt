package com.example.myf1.data.model

data class Driver(
    val driver_number: Int,
    val broadcast_name: String,
    val full_name: String,
    val name_acronym: String,
    val team_name: String,
    val team_colour: String,
    val first_name: String,
    val last_name: String,
    val headshot_url: String?,
    val country_code: String
)