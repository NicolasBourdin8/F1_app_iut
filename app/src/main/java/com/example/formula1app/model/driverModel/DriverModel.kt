package com.example.formula1app.model.driverModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DriverModel {
    @SerializedName("MRData")
    @Expose
    var mRData: MRData? = null
}