package com.example.formula1app.model.driverModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MRData(
    @SerializedName("total")
    val total: String,

    @SerializedName("StandingsTable")
    @Expose
    val standingsTable : StandingsTable
)
