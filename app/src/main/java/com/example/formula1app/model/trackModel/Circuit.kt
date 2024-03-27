package com.example.formula1app.model.trackModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Circuit {
    @SerializedName("circuitId")
    @Expose
    var circuitId: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("circuitName")
    @Expose
    var circuitName: String? = null

    @SerializedName("Location")
    @Expose
    var location: Location? = null
}