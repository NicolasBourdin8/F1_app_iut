package com.example.formula1app.model.trackModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Qualifying {
    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("time")
    @Expose
    var time: String? = null
}