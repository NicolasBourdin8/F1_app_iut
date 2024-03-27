package com.example.formula1app.model.constructorModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Constructors(
    @SerializedName("MRData")
    @Expose
    var mRData: MRData? = null
)