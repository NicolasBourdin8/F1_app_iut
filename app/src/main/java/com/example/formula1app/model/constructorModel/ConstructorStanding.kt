package com.example.formula1app.model.constructorModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ConstructorStanding {
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

    @SerializedName("Constructor")
    @Expose
    var constructor: Constructor? = null
}