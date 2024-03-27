package com.example.formula1app.model.constructorModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Constructor {
    @SerializedName("constructorId")
    @Expose
    var constructorId: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("nationality")
    @Expose
    var nationality: String? = null
}