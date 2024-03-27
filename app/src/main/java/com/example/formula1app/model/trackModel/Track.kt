package com.example.formula1app.model.trackModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Track {
    @SerializedName("MRData")
    @Expose
    var mRData: MRData? = null
}