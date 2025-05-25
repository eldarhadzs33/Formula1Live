package com.example.myf1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.myf1.data.model.Driver
import com.example.myf1.data.network.RetrofitClient

class DriversViewModel : ViewModel() {
    private val _drivers = MutableStateFlow<List<Driver>>(emptyList())
    val drivers: StateFlow<List<Driver>> = _drivers

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    init {
        fetchDrivers()
    }

    private fun fetchDrivers() {
        viewModelScope.launch {
            try {
                _drivers.value = RetrofitClient.api.getDrivers()
            } catch (e: Exception) {
                _drivers.value = emptyList()
            } finally {
                _loading.value = false
            }
        }
    }
}
