package com.example.formula1app.model.constructorModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName




class StandingsTable {
    @SerializedName("season")
    @Expose
    var season: String? = null

    @SerializedName("StandingsLists")
    @Expose
    var standingsLists: List<StandingsList?>? = null
}