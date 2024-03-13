package com.example.formula1app.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun create(url: String): ApiService {
            val retrofit: Retrofit by lazy {
                Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit.create(ApiService::class.java)
        }
    }
}