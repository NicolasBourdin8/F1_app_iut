package com.example.formula1app.model.driverModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class StandingsList {
    @SerializedName("season")
    @Expose
    var season: String? = null

    @SerializedName("round")
    @Expose
    var round: String? = null

    @SerializedName("DriverStandings")
    @Expose
    var driverStandings: List<DriverStanding>? = null
}