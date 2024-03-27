package com.example.formula1app.model.trackModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class RaceTable {
    @SerializedName("season")
    @Expose
    var season: String? = null

    @SerializedName("Races")
    @Expose
    var races: List<Race>? = null
}