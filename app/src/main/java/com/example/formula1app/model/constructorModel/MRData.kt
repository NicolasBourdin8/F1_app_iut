package com.example.formula1app.model.constructorModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class MRData {
    @SerializedName("xmlns")
    @Expose
    var xmlns: String? = null

    @SerializedName("series")
    @Expose
    var series: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("limit")
    @Expose
    var limit: String? = null

    @SerializedName("offset")
    @Expose
    var offset: String? = null

    @SerializedName("total")
    @Expose
    var total: String? = null

    @SerializedName("StandingsTable")
    @Expose
    var standingsTable: StandingsTable? = null
}