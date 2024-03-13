package com.example.formula1app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formula1app.model.ApiClient
import kotlinx.coroutines.launch

class ViewModelDrivers : ViewModel() {
    fun getDrivers() {
        try {
            viewModelScope.launch {
                try {
                    val apiService =
                        ApiClient.create("https://ergast.com/api/f1/current/")
                        apiService.getDrivers()
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }
}