package com.example.formula1app.model

import com.example.formula1app.model.constructorModel.Constructors
import com.example.formula1app.model.driverModel.DriverModel
import com.example.formula1app.model.trackModel.Track
import retrofit2.http.GET

interface ApiService {
    @GET("driverStandings.json")
    suspend fun getDrivers(): DriverModel

    @GET("constructorStandings.json")
    suspend fun getConstructors(): Constructors
    @GET("current.json")
    suspend fun getTracks(): Track
}