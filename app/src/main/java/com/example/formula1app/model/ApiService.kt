package com.example.formula1app.model

import com.example.formula1app.model.driverModel.DriverModel
import retrofit2.http.GET

interface ApiService {
    @GET("driverStandings.json")
    suspend fun getDrivers(): DriverModel
}