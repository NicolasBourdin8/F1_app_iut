package com.example.formula1app.model.driverModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class DriverStanding {
    @SerializedName("position")
    @Expose
    var position: String? = null

    @SerializedName("positionText")
    @Expose
    var positionText: String? = null

    @SerializedName("points")
    @Expose
    var points: String? = null

    @SerializedName("wins")
    @Expose
    var wins: String? = null

    @SerializedName("Driver")
    @Expose
    var driver: Driver? = null

    @SerializedName("Constructors")
    @Expose
    var constructors: List<Constructor>? = null
}