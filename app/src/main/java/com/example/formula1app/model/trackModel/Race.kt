package com.example.formula1app.model.trackModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Race {
    @SerializedName("season")
    @Expose
    var season: String? = null

    @SerializedName("round")
    @Expose
    var round: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("raceName")
    @Expose
    var raceName: String? = null

    @SerializedName("Circuit")
    @Expose
    var circuit: Circuit? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("time")
    @Expose
    var time: String? = null

    @SerializedName("FirstPractice")
    @Expose
    var firstPractice: FirstPractice? = null

    @SerializedName("SecondPractice")
    @Expose
    var secondPractice: SecondPractice? = null

    @SerializedName("ThirdPractice")
    @Expose
    var thirdPractice: ThirdPractice? = null

    @SerializedName("Qualifying")
    @Expose
    var qualifying: Qualifying? = null

    @SerializedName("Sprint")
    @Expose
    var sprint: Sprint? = null
}