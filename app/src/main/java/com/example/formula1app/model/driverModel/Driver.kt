package com.example.formula1app.model.driverModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Driver {
    @SerializedName("driverId")
    @Expose
    var driverId: String? = null

    @SerializedName("permanentNumber")
    @Expose
    var permanentNumber: String? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("givenName")
    @Expose
    var givenName: String? = null

    @SerializedName("familyName")
    @Expose
    var familyName: String? = null

    @SerializedName("dateOfBirth")
    @Expose
    var dateOfBirth: String? = null

    @SerializedName("nationality")
    @Expose
    var nationality: String? = null
}