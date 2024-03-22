package com.example.formula1app.model.driverModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class StandingsTable (
    @SerializedName("StandingsLists")
    @Expose
    var standingsLists: List<StandingsList>? = null
)