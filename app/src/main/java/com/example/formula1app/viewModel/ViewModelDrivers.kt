package com.example.formula1app.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1app.model.ApiClient
import com.example.formula1app.model.driverModel.DriverModel
import kotlinx.coroutines.launch

class ViewModelDrivers : ViewModel() {
    var listPilot = mutableStateOf<DriverModel?>(null)
    fun getDrivers() {

        viewModelScope.launch {
            try {
                val apiService = ApiClient.create("https://ergast.com/api/f1/current/")
                listPilot.value = apiService.getDrivers()
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}