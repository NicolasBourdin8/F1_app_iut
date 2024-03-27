package com.example.formula1app.model.trackModel

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Location : Serializable{
    @SerializedName("lat")
    @Expose
    var lat: String? = null

    @SerializedName("long")
    @Expose
    var long: String? = null

    @SerializedName("locality")
    @Expose
    var locality: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null
}