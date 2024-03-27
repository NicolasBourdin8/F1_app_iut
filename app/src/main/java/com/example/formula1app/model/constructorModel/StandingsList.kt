package com.example.formula1app.model.constructorModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class StandingsList {
    @SerializedName("season")
    @Expose
    var season: String? = null

    @SerializedName("round")
    @Expose
    var round: String? = null

    @SerializedName("ConstructorStandings")
    @Expose
    var constructorStandings: List<ConstructorStanding>? = null
}