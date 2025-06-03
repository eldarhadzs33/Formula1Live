package com.example.myf1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myf1.data.model.CarData
import com.example.myf1.data.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TelemetryViewModel(): ViewModel() {
    private val _telemetryData = MutableStateFlow<List<CarData>>(emptyList())
    val telemetryData: StateFlow<List<CarData>> = _telemetryData

    init {
        fetchTelemetry(driverNumber = 1) // <-- Ovo ti treba!
    }

    fun fetchTelemetry(driverNumber: Int) {
        viewModelScope.launch {
            try {
                _telemetryData.value = RetrofitClient.api.getCarData(driverNumber = driverNumber)
            } catch (e: Exception) {
                e.printStackTrace()
                _telemetryData.value = emptyList()
            }
        }
    }
}
