package com.example.formula1app.model

import retrofit2.http.GET

interface ApiService {
    @GET("current/driverStandings.json")
    suspend fun getDrivers(): List<Driver>
}